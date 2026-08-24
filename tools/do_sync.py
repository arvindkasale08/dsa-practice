import sys
sys.path.append('./tools/python_lib')
import urllib.request
import urllib.parse
import json
import time
import websocket

class CDPClient:
    def __init__(self, ws_url):
        self.ws_url = ws_url
        self.ws = None
        self.msg_id = 1

    def connect(self):
        self.ws = websocket.create_connection(self.ws_url)

    def send(self, method, params=None):
        if params is None:
            params = {}
        payload = {
            "id": self.msg_id,
            "method": method,
            "params": params
        }
        self.msg_id += 1
        self.ws.send(json.dumps(payload))
        
        while True:
            res = json.loads(self.ws.recv())
            if res.get("id") == payload["id"]:
                if "error" in res:
                    raise Exception(f"CDP Error in {method}: {res['error']}")
                return res.get("result")

    def evaluate(self, expression):
        res = self.send("Runtime.evaluate", {
            "expression": expression,
            "returnByValue": True,
            "awaitPromise": True
        })
        if "exceptionDetails" in res:
            raise Exception(f"Eval failed: {res['exceptionDetails']['exception'].get('description')}")
        return res["result"].get("value")

    def close(self):
        if self.ws:
            self.ws.close()

def main():
    print("Fetching active tabs from Chrome...")
    req = urllib.request.Request('http://localhost:9222/json')
    req.add_header('Host', 'localhost:9222')
    tabs = json.loads(urllib.request.urlopen(req).read().decode())
    
    nc_tab = None
    gs_tab = None
    
    for tab in tabs:
        if tab.get('type') == 'page' and tab.get('url'):
            if 'neetcode.io/roadmap' in tab['url']:
                nc_tab = tab
            elif 'docs.google.com/spreadsheets' in tab['url']:
                gs_tab = tab
                
    if not nc_tab:
        raise Exception("Neetcode tab not found!")
    if not gs_tab:
        raise Exception("Google Sheets tab not found!")
        
    print(f"NeetCode Tab: {nc_tab['title']} -> {nc_tab['url']}")
    print(f"Google Sheets Tab: {gs_tab['title']} -> {gs_tab['url']}")
    
    # 1. Connect to NeetCode and click Backtracking
    print("\nConnecting to NeetCode tab...")
    nc_client = CDPClient(nc_tab['webSocketDebuggerUrl'])
    nc_client.connect()
    
    print("Checking if Backtracking node is visible...")
    found_node = False
    for i in range(20):
        found_node = nc_client.evaluate("""(() => {
            const els = Array.from(document.querySelectorAll('g, text, div, p, span'));
            return els.some(el => el.textContent && el.textContent.trim() === 'Backtracking');
        })()""")
        if found_node:
            break
        time.sleep(1)
        
    if not found_node:
        raise Exception("Backtracking node not found on NeetCode roadmap page!")
        
    print("Clicking 'Backtracking' node...")
    nc_client.evaluate("""(() => {
        const els = Array.from(document.querySelectorAll('g, text, div, p, span'));
        const node = els.find(el => el.textContent && el.textContent.trim() === 'Backtracking');
        if (typeof node.click === 'function') {
            node.click();
        } else {
            node.dispatchEvent(new MouseEvent('click', { bubbles: true, cancelable: true }));
        }
    })()""")
    
    print("Waiting 3 seconds for sidebar/modal to load...")
    time.sleep(3)
    
    print("Scraping problems under Backtracking...")
    problems = nc_client.evaluate("""(() => {
        const links = Array.from(document.querySelectorAll('a[href*="leetcode.com/problems"], a[href*="neetcode.io/problems"]'));
        return links.map(link => {
            let parent = link.parentElement;
            let isSolved = false;
            for (let i = 0; i < 6; i++) {
                if (!parent) break;
                const checkbox = parent.querySelector('input[type="checkbox"]');
                if (checkbox && checkbox.checked) {
                    isSolved = true;
                    break;
                }
                const svg = parent.querySelector('svg');
                if (svg) {
                    const style = window.getComputedStyle(svg);
                    const fill = style.fill;
                    const color = style.color;
                    if (fill.includes('37') || fill.includes('84') || fill.includes('success') || fill.includes('25ab54') ||
                        color.includes('37') || color.includes('84') || color.includes('success') || color.includes('25ab54')) {
                        isSolved = true;
                        break;
                    }
                }
                if (parent.className && (parent.className.includes('solved') || parent.className.includes('completed') || parent.className.includes('checked'))) {
                    isSolved = true;
                    break;
                }
                parent = parent.parentElement;
            }
            return {
                name: link.textContent.trim(),
                url: link.href,
                isSolved: isSolved
            };
        });
    })()""")
    
    nc_client.close()
    
    solved_problems = [p for p in problems if p['isSolved'] and p['name']]
    print(f"Total problems found: {len(problems)}")
    print(f"Solved problems: {len(solved_problems)}")
    for p in solved_problems:
        print(f" - {p['name']}: {p['url']}")
        
    if not solved_problems:
        print("No solved backtracking problems found. Exiting.")
        return
        
    # 2. Connect to Google Sheets and fetch data
    print("\nConnecting to Google Sheets tab...")
    gs_client = CDPClient(gs_tab['webSocketDebuggerUrl'])
    gs_client.connect()
    
    print("Fetching existing sheet data as TSV...")
    tsv_text = gs_client.evaluate("fetch('https://docs.google.com/spreadsheets/d/1U4zxsmOFeb92TRb5ZNeLIaN9PTfOM33XNyN4gO0xLTY/export?format=tsv&gid=1723456789').then(r => r.text())")
    
    rows = [line.split('\t') for line in tsv_text.strip().split('\n')]
    headers = rows[0]
    print(f"Headers: {headers}")
    
    name_col_idx = -1
    url_col_idx = -1
    source_col_idx = -1
    
    for idx, h in enumerate(headers):
        h_lower = h.lower()
        if 'name' in h_lower or 'problem' in h_lower or 'title' in h_lower:
            name_col_idx = idx
        if 'url' in h_lower or 'link' in h_lower or 'leetcode' in h_lower:
            url_col_idx = idx
        if 'source' in h_lower:
            source_col_idx = idx
            
    if name_col_idx == -1 or url_col_idx == -1:
        raise Exception(f"Failed to parse column indexes. Name: {name_col_idx}, URL: {url_col_idx}")
        
    print(f"Mapped Name column: {name_col_idx}, URL column: {url_col_idx}, Source column: {source_col_idx}")
    
    existing_urls = set()
    existing_names = set()
    for row in rows[1:]:
        if len(row) > url_col_idx:
            existing_urls.add(row[url_col_idx].strip().split('?')[0])
        if len(row) > name_col_idx:
            existing_names.add(row[name_col_idx].strip().lower())
            
    new_problems = []
    for p in solved_problems:
        clean_url = p['url'].strip().split('?')[0]
        clean_name = p['name'].strip().lower()
        if clean_url not in existing_urls and clean_name not in existing_names:
            new_problems.append(p)
            
    print(f"New solved problems to sync: {len(new_problems)}")
    for p in new_problems:
        print(f" + {p['name']}")
        
    if not new_problems:
        print("All solved problems are already in the sheet. No sync needed!")
        gs_client.close()
        return
        
    # Format new solved problems as TSV
    tsv_rows = []
    for p in new_problems:
        row_data = [""] * len(headers)
        row_data[name_col_idx] = p['name']
        row_data[url_col_idx] = p['url']
        if source_col_idx != -1:
            row_data[source_col_idx] = "NeetCode"
        tsv_rows.append("\t".join(row_data))
        
    tsv_to_paste = "\n".join(tsv_rows) + "\n"
    
    # 3. Move selection to row N+1
    current_row_count = len(rows)
    print(f"Moving selection to first empty cell (row {current_row_count + 1})...")
    
    # Send Home (Ctrl+Home)
    print("Pressing Home (Ctrl+Home)...")
    gs_client.send("Input.dispatchKeyEvent", {
        "type": "rawKeyDown",
        "key": "Home",
        "windowsVirtualKeyCode": 36,
        "modifiers": 2 # Ctrl
    })
    gs_client.send("Input.dispatchKeyEvent", {
        "type": "keyUp",
        "key": "Home",
        "windowsVirtualKeyCode": 36,
        "modifiers": 2
    })
    time.sleep(0.5)
    
    # Press ArrowDown current_row_count times
    print(f"Pressing ArrowDown {current_row_count} times...")
    for i in range(current_row_count):
        gs_client.send("Input.dispatchKeyEvent", {
            "type": "rawKeyDown",
            "key": "ArrowDown",
            "windowsVirtualKeyCode": 40
        })
        gs_client.send("Input.dispatchKeyEvent", {
            "type": "keyUp",
            "key": "ArrowDown",
            "windowsVirtualKeyCode": 40
        })
        time.sleep(0.02)
        
    time.sleep(1.0)
    
    # 4. Dispatch mock paste event
    print("Dispatching mock paste event with TSV data...")
    escaped_tsv = tsv_to_paste.replace("`", "\\`").replace("$", "\\$")
    gs_client.evaluate(f"""(() => {{
        const tsvData = `{escaped_tsv}`;
        const dt = new DataTransfer();
        dt.setData('text/plain', tsvData);
        const event = new ClipboardEvent('paste', {{
            clipboardData: dt,
            bubbles: true,
            cancelable: true
        }});
        const activeEl = document.activeElement || document.body;
        activeEl.dispatchEvent(event);
    }})()""")
    
    print("Waiting 5 seconds for Google Sheets to process and save the paste...")
    time.sleep(5)
    
    print("\nSync completed successfully!")
    gs_client.close()

if __name__ == "__main__":
    main()
