#!/usr/bin/env node

import fs from "node:fs";
import path from "node:path";

const repoRoot = path.resolve(new URL("..", import.meta.url).pathname);
const progressDir = path.join(repoRoot, "revised/progress");
const logPath = path.join(progressDir, "daily-solved.json");
const outputPath = path.join(progressDir, "index.html");

const log = JSON.parse(fs.readFileSync(logPath, "utf8"));
const entries = [...(log.entries || [])].sort((a, b) => a.date.localeCompare(b.date));
const total = entries.reduce((sum, entry) => sum + Number(entry.solved || 0), 0);
const best = entries.reduce((winner, entry) => Number(entry.solved || 0) > Number(winner.solved || 0) ? entry : winner, entries[0] || { solved: 0, date: "" });
const updated = new Intl.DateTimeFormat("en-IN", {
  timeZone: log.timezone || "Asia/Kolkata",
  dateStyle: "medium",
  timeStyle: "short"
}).format(new Date());

function escapeHtml(value) {
  return String(value ?? "")
    .replaceAll("&", "&amp;")
    .replaceAll("<", "&lt;")
    .replaceAll(">", "&gt;")
    .replaceAll("\"", "&quot;");
}

function renderCards(cards) {
  if (!cards?.length) return "<span class=\"muted\">No new cards</span>";
  return `<div class="chips">${cards.map(card => `<span>${escapeHtml(card)}</span>`).join("")}</div>`;
}

const rows = entries.map(entry => `
  <tr data-date="${escapeHtml(entry.date)}" data-count="${Number(entry.solved || 0)}">
    <td>${escapeHtml(entry.date)}</td>
    <td class="count">${Number(entry.solved || 0)}</td>
    <td>${renderCards(entry.cardsSynced || [])}</td>
    <td>${escapeHtml(entry.notes || "")}</td>
  </tr>
`).join("");

const html = `<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>DSA Daily Progress</title>
  <style>
    :root {
      --ink: #17211d;
      --muted: #607068;
      --paper: #eef3ef;
      --panel: #fffefa;
      --line: #cbd8cf;
      --green: #176b51;
      --blue: #326c94;
      --gold: #a96b16;
    }
    * { box-sizing: border-box; }
    body {
      margin: 0;
      font-family: Inter, ui-sans-serif, system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI", sans-serif;
      background: var(--paper);
      color: var(--ink);
      border-top: 4px solid var(--green);
    }
    main {
      width: min(1180px, 100%);
      margin: 0 auto;
      padding: 24px 18px 48px;
    }
    .back-link {
      display: inline-flex;
      align-items: center;
      min-height: 34px;
      margin-bottom: 14px;
      border: 1px solid var(--line);
      border-radius: 8px;
      background: var(--panel);
      color: var(--green);
      padding: 5px 10px;
      font-size: 14px;
      font-weight: 800;
      text-decoration: none;
    }
    header {
      display: flex;
      justify-content: space-between;
      gap: 18px;
      align-items: end;
      flex-wrap: wrap;
      margin-bottom: 18px;
    }
    h1 {
      margin: 0;
      font-size: clamp(34px, 5vw, 58px);
      line-height: 1;
      letter-spacing: 0;
    }
    .subtitle {
      margin: 8px 0 0;
      color: var(--muted);
      max-width: 760px;
    }
    .summary {
      display: grid;
      grid-template-columns: repeat(3, minmax(0, 1fr));
      gap: 12px;
      margin-bottom: 18px;
    }
    .metric, .panel {
      border: 1px solid var(--line);
      border-radius: 8px;
      background: var(--panel);
      box-shadow: 0 10px 24px rgba(31, 53, 42, .08);
    }
    .metric {
      padding: 14px;
    }
    .label {
      display: block;
      color: var(--muted);
      font-size: 13px;
      font-weight: 800;
      text-transform: uppercase;
      letter-spacing: .04em;
    }
    .value {
      display: block;
      margin-top: 6px;
      font-size: 32px;
      font-weight: 950;
    }
    .tools {
      display: flex;
      gap: 8px;
      align-items: center;
    }
    input {
      width: min(360px, 100%);
      height: 40px;
      border: 1px solid var(--line);
      border-radius: 8px;
      background: var(--panel);
      padding: 0 12px;
      font: inherit;
    }
    table {
      width: 100%;
      border-collapse: collapse;
    }
    th, td {
      padding: 12px;
      border-bottom: 1px solid var(--line);
      text-align: left;
      vertical-align: top;
    }
    th {
      position: sticky;
      top: 0;
      background: #f8fbf8;
      color: var(--muted);
      font-size: 13px;
      text-transform: uppercase;
      letter-spacing: .04em;
      cursor: pointer;
    }
    tr:hover td { background: #f6faf7; }
    .count {
      color: var(--green);
      font-size: 22px;
      font-weight: 950;
    }
    .chips {
      display: flex;
      flex-wrap: wrap;
      gap: 6px;
    }
    .chips span {
      border: 1px solid #bad9ca;
      border-radius: 999px;
      background: #e1f2e9;
      color: #0f4f3c;
      padding: 4px 8px;
      font-size: 13px;
      font-weight: 800;
    }
    .muted { color: var(--muted); }
    @media (max-width: 760px) {
      .summary { grid-template-columns: 1fr; }
      table { font-size: 14px; }
      th, td { padding: 10px 8px; }
    }
  </style>
</head>
<body>
  <main>
    <a class="back-link" href="../">Back to revision files</a>
    <header>
      <div>
        <h1>DSA Daily Progress</h1>
        <p class="subtitle">Counts are based on newly synced revision cards. Updated ${escapeHtml(updated)}.</p>
      </div>
      <div class="tools">
        <input id="filter" type="search" placeholder="Filter cards or notes">
      </div>
    </header>

    <section class="summary">
      <div class="metric"><span class="label">Total solved</span><span class="value">${total}</span></div>
      <div class="metric"><span class="label">Tracked days</span><span class="value">${entries.length}</span></div>
      <div class="metric"><span class="label">Best day</span><span class="value">${escapeHtml(best.date || "-")} · ${Number(best.solved || 0)}</span></div>
    </section>

    <section class="panel">
      <table>
        <thead>
          <tr>
            <th data-sort="date">Date</th>
            <th data-sort="count">Solved</th>
            <th>Cards synced</th>
            <th>Notes</th>
          </tr>
        </thead>
        <tbody id="rows">
          ${rows}
        </tbody>
      </table>
    </section>
  </main>
  <script>
    const filter = document.getElementById("filter");
    const tbody = document.getElementById("rows");
    let sortKey = "date";
    let sortDir = -1;

    function apply() {
      const q = filter.value.trim().toLowerCase();
      const rows = Array.from(tbody.querySelectorAll("tr"));
      rows.forEach(row => {
        row.hidden = q && !row.textContent.toLowerCase().includes(q);
      });
    }

    function sortRows(key) {
      if (sortKey === key) sortDir *= -1;
      else {
        sortKey = key;
        sortDir = key === "date" ? -1 : 1;
      }
      const rows = Array.from(tbody.querySelectorAll("tr"));
      rows.sort((a, b) => {
        const av = key === "count" ? Number(a.dataset.count) : a.dataset.date;
        const bv = key === "count" ? Number(b.dataset.count) : b.dataset.date;
        return av > bv ? sortDir : av < bv ? -sortDir : 0;
      });
      rows.forEach(row => tbody.appendChild(row));
      apply();
    }

    filter.addEventListener("input", apply);
    document.querySelectorAll("th[data-sort]").forEach(th => {
      th.addEventListener("click", () => sortRows(th.dataset.sort));
    });
    sortRows("date");
  </script>
</body>
</html>
`;

fs.writeFileSync(outputPath, html);
console.log(`Generated ${path.relative(repoRoot, outputPath)}`);
