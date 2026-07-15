#!/usr/bin/env node

import fs from "node:fs";
import path from "node:path";

const repoRoot = path.resolve(new URL("..", import.meta.url).pathname);
const logPath = path.join(repoRoot, "revised/progress/daily-solved.json");

function todayInTimeZone(timeZone) {
  const parts = new Intl.DateTimeFormat("en-CA", {
    timeZone,
    year: "numeric",
    month: "2-digit",
    day: "2-digit"
  }).formatToParts(new Date());

  const values = Object.fromEntries(parts.map(part => [part.type, part.value]));
  return `${values.year}-${values.month}-${values.day}`;
}

function readLog() {
  if (!fs.existsSync(logPath)) {
    return { version: 1, timezone: "Asia/Kolkata", entries: [] };
  }
  return JSON.parse(fs.readFileSync(logPath, "utf8"));
}

function writeLog(log) {
  fs.mkdirSync(path.dirname(logPath), { recursive: true });
  fs.writeFileSync(logPath, `${JSON.stringify(log, null, 2)}\n`);
}

function argValue(name, fallback = "") {
  const index = process.argv.indexOf(name);
  return index === -1 ? fallback : process.argv[index + 1] ?? fallback;
}

function hasFlag(name) {
  return process.argv.includes(name);
}

function printUsage() {
  console.log(`
Usage:
  node tools/record-daily-solved.mjs --summary
  node tools/record-daily-solved.mjs --add 1 --card backtracking/AtoIRecurse --note "Synced card"
  node tools/record-daily-solved.mjs --date 2026-07-15 --add 2 --card backtracking/SortStack --card backtracking/ReverseAStack
`.trim());
}

function main() {
  if (hasFlag("--help")) {
    printUsage();
    return;
  }

  const log = readLog();
  const timeZone = log.timezone || "Asia/Kolkata";

  if (hasFlag("--summary")) {
    const total = log.entries.reduce((sum, entry) => sum + Number(entry.solved || 0), 0);
    const latest = log.entries.at(-1);
    console.log(`Total solved from card syncs: ${total}`);
    if (latest) {
      console.log(`Latest day: ${latest.date} = ${latest.solved}`);
    }
    return;
  }

  const add = Number(argValue("--add", "0"));
  if (!Number.isInteger(add) || add < 0) {
    throw new Error("--add must be a non-negative integer");
  }

  const date = argValue("--date", todayInTimeZone(timeZone));
  const note = argValue("--note", "");
  const cards = process.argv
    .map((arg, index) => (arg === "--card" ? process.argv[index + 1] : ""))
    .filter(Boolean);

  let entry = log.entries.find(item => item.date === date);
  if (!entry) {
    entry = { date, solved: 0, cardsSynced: [], notes: "" };
    log.entries.push(entry);
  }

  entry.solved = Number(entry.solved || 0) + add;
  entry.cardsSynced = Array.from(new Set([...(entry.cardsSynced || []), ...cards]));
  if (note) {
    entry.notes = entry.notes ? `${entry.notes} ${note}` : note;
  }

  writeLog(log);
  console.log(`${date}: ${entry.solved} solved`);
}

main();
