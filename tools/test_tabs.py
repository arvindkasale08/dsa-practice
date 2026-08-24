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

def get_or_create_tab(url_substr, default_url, browser_ws_url):
    req = urllib.request.Request('http://localhost:9222/json')
    req.add_header('Host', 'localhost:9222')
    tabs = json.loads(urllib.request.urlopen(req).read().decode())
    
    for tab in tabs:
        if tab.get('type') == 'page' and tab.get('url') and url_substr in tab['url']:
            print(f"Found existing tab: {tab.get('title')} -> {tab.get('url')}")
            return tab
            
    print(f"Creating tab for: {default_url}")
    client = CDPClient(browser_ws_url)
    client.connect()
    res = client.send("Target.createTarget", {"url": default_url})
    client.close()
    
    target_id = res['targetId']
    for _ in range(10):
        time.sleep(1)
        req = urllib.request.Request('http://localhost:9222/json')
        req.add_header('Host', 'localhost:9222')
        tabs = json.loads(urllib.request.urlopen(req).read().decode())
        for tab in tabs:
            if tab.get('id') == target_id:
                return tab
    raise Exception(f"Failed to find created tab {target_id}")

# Get browser websocket URL
req = urllib.request.Request('http://localhost:9222/json/version')
req.add_header('Host', 'localhost:9222')
version_info = json.loads(urllib.request.urlopen(req).read().decode())
browser_ws_url = version_info['webSocketDebuggerUrl']

print("Getting/Creating NeetCode tab:")
nc_tab = get_or_create_tab('neetcode.io/roadmap', 'https://neetcode.io/roadmap', browser_ws_url)

print("\nGetting/Creating Google Sheets tab:")
gs_tab = get_or_create_tab('docs.google.com/spreadsheets', 'https://docs.google.com/spreadsheets/d/1U4zxsmOFeb92TRb5ZNeLIaN9PTfOM33XNyN4gO0xLTY/edit#gid=1723456789', browser_ws_url)

print("\nWaiting for pages to load...")
time.sleep(5)

print("\nAll open tabs:")
req = urllib.request.Request('http://localhost:9222/json')
req.add_header('Host', 'localhost:9222')
tabs = json.loads(urllib.request.urlopen(req).read().decode())
for t in tabs:
    if t.get('type') == 'page':
        print(f"- {t.get('title')}: {t.get('url')}")
