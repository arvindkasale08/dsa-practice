#!/usr/bin/env node

import { writeFileSync } from 'node:fs';

const CHROME_PORT = 9222;
const SHEET_GID = '1723456789';
const SHEET_URL = `https://docs.google.com/spreadsheets/d/1U4zxsmOFeb92TRb5ZNeLIaN9PTfOM33XNyN4gO0xLTY/edit?gid=${SHEET_GID}#gid=${SHEET_GID}`;

class CDPClient {
  constructor(wsUrl) {
    this.wsUrl = wsUrl;
    this.ws = null;
    this.id = 1;
    this.callbacks = new Map();
  }

  connect() {
    return new Promise((resolve, reject) => {
      this.ws = new WebSocket(this.wsUrl);
      this.ws.onopen = () => resolve();
      this.ws.onerror = (err) => reject(err);
      this.ws.onmessage = (event) => {
        const msg = JSON.parse(event.data);
        if (msg.id && this.callbacks.has(msg.id)) {
          const { resolve, reject } = this.callbacks.get(msg.id);
          this.callbacks.delete(msg.id);
          if (msg.error) {
            reject(msg.error);
          } else {
            resolve(msg.result);
          }
        }
      };
    });
  }

  send(method, params = {}) {
    return new Promise((resolve, reject) => {
      const messageId = this.id++;
      this.callbacks.set(messageId, { resolve, reject });
      this.ws.send(JSON.stringify({ id: messageId, method, params }));
    });
  }

  close() {
    if (this.ws) {
      this.ws.close();
    }
  }
}

async function evaluate(client, expression) {
  const res = await client.send('Runtime.evaluate', {
    expression,
    returnByValue: true,
    awaitPromise: true
  });
  if (res.exceptionDetails) {
    throw new Error(`Eval failed: ${res.exceptionDetails.exception.description}`);
  }
  return res.result.value;
}

async function sleep(ms) {
  return new Promise(r => setTimeout(r, ms));
}

async function waitForSelector(client, selector, timeoutMs = 15000) {
  const start = Date.now();
  while (Date.now() - start < timeoutMs) {
    const exists = await evaluate(client, `!!document.querySelector('${selector}')`);
    if (exists) return true;
    await sleep(500);
  }
  throw new Error(`Timeout waiting for selector: ${selector}`);
}

async function getOrOpenTab(urlSubstr, defaultUrl) {
  const res = await fetch(`http://127.0.0.1:${CHROME_PORT}/json`);
  const tabs = await res.json();
  
  let tab = tabs.find(t => t.url && t.url.includes(urlSubstr));
  if (tab) {
    console.log(`Found existing tab for ${urlSubstr}: ${tab.title}`);
    return tab;
  }
  
  console.log(`Opening new tab for ${defaultUrl}...`);
  const openRes = await fetch(`http://127.0.0.1:${CHROME_PORT}/json/new?url=${encodeURIComponent(defaultUrl)}`);
  return await openRes.json();
}

async function main() {
  console.log('Connecting to Chrome...');
  
  let neetcodeTabInfo, sheetTabInfo;
  try {
    neetcodeTabInfo = await getOrOpenTab('neetcode.io/roadmap', 'https://neetcode.io/roadmap');
    sheetTabInfo = await getOrOpenTab('docs.google.com/spreadsheets', SHEET_URL);
  } catch (err) {
    console.error('Error: Could not connect to Chrome. Is Chrome running with --remote-debugging-port=9222?');
    console.error(err.message);
    process.exit(1);
  }

  // 1. Fetch solved backtracking problems from NeetCode
  console.log('\n--- 1. Fetching solved problems from NeetCode ---');
  const ncClient = new CDPClient(neetcodeTabInfo.webSocketDebuggerUrl);
  await ncClient.connect();
  await ncClient.send('Page.enable');
  await ncClient.send('Runtime.enable');

  console.log('Checking page load status...');
  await sleep(2000); // Give it a moment to boot
  
  // Wait for the roadmap nodes to render
  console.log('Waiting for roadmap nodes to load...');
  await evaluate(ncClient, `new Promise(resolve => {
    if (document.readyState === 'complete') resolve();
    window.addEventListener('load', resolve);
  })`);
  
  // Wait until we can find the Backtracking node text
  let foundNode = false;
  for (let i = 0; i < 20; i++) {
    foundNode = await evaluate(ncClient, `(() => {
      const els = Array.from(document.querySelectorAll('g, text, div, p, span'));
      return els.some(el => el.textContent && el.textContent.trim() === 'Backtracking');
    })()`);
    if (foundNode) break;
    await sleep(1000);
  }
  
  if (!foundNode) {
    throw new Error('Could not find "Backtracking" node on the roadmap. Make sure the page is fully loaded.');
  }

  console.log('Found "Backtracking" node. Clicking it...');
  await evaluate(ncClient, `(() => {
    const els = Array.from(document.querySelectorAll('g, text, div, p, span'));
    const node = els.find(el => el.textContent && el.textContent.trim() === 'Backtracking');
    node.click();
  })()`);

  console.log('Waiting for Backtracking problems sidebar/modal to open...');
  await sleep(3000); // Wait for the modal animation and elements to load

  // Scrape problems
  console.log('Scraping problems list...');
  const problems = await evaluate(ncClient, `(() => {
    // Find all links to leetcode.com or neetcode.io problems inside the sidebar
    // Typically neetcode sidebar links contain /problems/ or leetcode.com
    const links = Array.from(document.querySelectorAll('a[href*="leetcode.com/problems"], a[href*="neetcode.io/problems"]'));
    
    return links.map(link => {
      // Find the row/container of this problem
      let parent = link.parentElement;
      let isSolved = false;
      
      // Look up to 6 parents for checkmark
      for (let i = 0; i < 6; i++) {
        if (!parent) break;
        
        // 1. Check for standard checkbox
        const checkbox = parent.querySelector('input[type="checkbox"]');
        if (checkbox && checkbox.checked) {
          isSolved = true;
          break;
        }
        
        // 2. Check for checkmark icon (typically has green color or matches class/svg)
        const svg = parent.querySelector('svg');
        if (svg) {
          const style = window.getComputedStyle(svg);
          const fill = style.fill;
          const color = style.color;
          // Neetcode green is #25ab54 or rgb(37, 171, 84)
          if (fill.includes('37') || fill.includes('84') || fill.includes('success') || fill.includes('25ab54') ||
              color.includes('37') || color.includes('84') || color.includes('success') || color.includes('25ab54')) {
            isSolved = true;
            break;
          }
        }
        
        // 3. Sibling or parent class names containing completed/solved
        if (parent.className && (parent.className.includes('solved') || parent.className.includes('completed') || parent.className.includes('checked'))) {
          isSolved = true;
          break;
        }
        
        parent = parent.parentElement;
      }
      
      return {
        name: link.textContent.trim(),
        url: link.href,
        isSolved
      };
    });
  })()`);

  ncClient.close();

  const solvedProblems = problems.filter(p => p.isSolved && p.name);
  console.log(`\nFound ${problems.length} total backtracking problems. ${solvedProblems.length} are solved.`);
  console.log('Solved problems:', solvedProblems.map(p => p.name));

  if (solvedProblems.length === 0) {
    console.log('No solved problems to sync. Exiting.');
    process.exit(0);
  }

  // 2. Sync to Google Sheets
  console.log('\n--- 2. Connecting to Google Sheets ---');
  const gsClient = new CDPClient(sheetTabInfo.webSocketDebuggerUrl);
  await gsClient.connect();
  await gsClient.send('Page.enable');
  await gsClient.send('Runtime.enable');
  
  // Wait for Google Sheet to load
  console.log('Waiting for Google Sheet to load...');
  await sleep(3000);
  
  // Fetch current sheet data as TSV (bypassing CORS by requesting from sheet context)
  console.log('Fetching sheet structure and data via TSV export...');
  const tsvUrl = `https://docs.google.com/spreadsheets/d/1U4zxsmOFeb92TRb5ZNeLIaN9PTfOM33XNyN4gO0xLTY/export?format=tsv&gid=${SHEET_GID}`;
  const tsvText = await evaluate(gsClient, `fetch('${tsvUrl}').then(r => r.text())`);
  
  const rows = tsvText.split('\n').map(line => line.split('\t').map(c => c.trim()));
  const headers = rows[0] || [];
  console.log('Detected column headers:', headers);
  
  const nameColIdx = headers.findIndex(h => /name|problem|title/i.test(h));
  const urlColIdx = headers.findIndex(h => /url|link|leetcode/i.test(h));
  const sourceColIdx = headers.findIndex(h => /source/i.test(h));
  
  if (nameColIdx === -1 || urlColIdx === -1) {
    throw new Error(`Could not map essential columns in the Google Sheet. Name index: ${nameColIdx}, URL index: ${urlColIdx}`);
  }
  
  console.log(`Mapped Name column: "${headers[nameColIdx]}" (index ${nameColIdx}), URL column: "${headers[urlColIdx]}" (index ${urlColIdx}), Source column: ${sourceColIdx !== -1 ? `"${headers[sourceColIdx]}" (index ${sourceColIdx})` : 'Not Found'}`);

  // Deduplicate against existing problems
  const existingUrls = new Set(rows.slice(1).map(r => r[urlColIdx]).filter(Boolean));
  const existingNames = new Set(rows.slice(1).map(r => r[nameColIdx]).filter(Boolean));
  
  const newSolvedProblems = solvedProblems.filter(p => {
    // Check if the URL matches (matching basic path to ignore query parameters)
    const cleanUrl = p.url.split('?')[0];
    const isDup = Array.from(existingUrls).some(existingUrl => existingUrl.split('?')[0] === cleanUrl) ||
                  existingNames.has(p.name);
    return !isDup;
  });

  console.log(`\nNew solved problems to append: ${newSolvedProblems.length}`);
  if (newSolvedProblems.length === 0) {
    console.log('All solved problems are already recorded in the sheet. No sync required!');
    gsClient.close();
    process.exit(0);
  }
  
  console.log('Problems to append:', newSolvedProblems.map(p => p.name));

  // Prepare the TSV block to paste
  let tsvToPaste = '';
  for (const p of newSolvedProblems) {
    const rowData = new Array(headers.length).fill('');
    rowData[nameColIdx] = p.name;
    rowData[urlColIdx] = p.url;
    if (sourceColIdx !== -1) {
      rowData[sourceColIdx] = 'NeetCode';
    }
    tsvToPaste += rowData.join('\t') + '\n';
  }

  // Focus sheet and perform the paste
  console.log('\nPreparing to paste new rows into Google Sheets...');
  
  // Navigate the active cell to the end of the sheet
  const currentRowCount = rows.length;
  console.log(`Current rows count: ${currentRowCount}. Selection needs to move to row ${currentRowCount + 1}.`);
  
  // We will run a script to simulate pressing Ctrl+Home, then Down Arrow currentRowCount times
  // Wait, let's select the main grid first by dispatching key events on the active element
  // First, let's send Ctrl+Home to focus cell A1/A2
  console.log('Moving focus to cell A1 (Ctrl+Home)...');
  await gsClient.send('Input.dispatchKeyEvent', {
    type: 'rawKeyDown',
    key: 'Home',
    windowsVirtualKeyCode: 36,
    modifiers: 2 // Ctrl
  });
  await gsClient.send('Input.dispatchKeyEvent', {
    type: 'keyUp',
    key: 'Home',
    windowsVirtualKeyCode: 36,
    modifiers: 2 // Ctrl
  });
  await sleep(500);

  // Press ArrowDown currentRowCount times
  console.log(`Pressing ArrowDown ${currentRowCount} times to reach the first empty row (row ${currentRowCount + 1})...`);
  for (let i = 0; i < currentRowCount; i++) {
    await gsClient.send('Input.dispatchKeyEvent', {
      type: 'rawKeyDown',
      key: 'ArrowDown',
      windowsVirtualKeyCode: 40
    });
    await gsClient.send('Input.dispatchKeyEvent', {
      type: 'keyUp',
      key: 'ArrowDown',
      windowsVirtualKeyCode: 40
    });
    // Add a tiny delay to allow Google Sheets to process
    await sleep(20);
  }
  await sleep(1000);

  // Perform paste by dispatching a clipboard event
  console.log('Dispatching paste event with data...');
  await evaluate(gsClient, `(() => {
    const tsvData = \`${tsvToPaste.replace(/`/g, '\\`').replace(/\$/g, '\\$')}\`;
    const dt = new DataTransfer();
    dt.setData('text/plain', tsvData);
    const event = new ClipboardEvent('paste', {
      clipboardData: dt,
      bubbles: true,
      cancelable: true
    });
    
    // We send it to the active element
    const activeEl = document.activeElement || document.body;
    activeEl.dispatchEvent(event);
  })()`);

  console.log('Waiting for Google Sheets to save the data...');
  await sleep(5000);
  
  console.log('Sync complete!');
  gsClient.close();
}

main().catch(err => {
  console.error('Fatal error during sync:', err);
  process.exit(1);
});
