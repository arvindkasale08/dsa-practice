#!/usr/bin/env node

import fs from "node:fs";
import os from "node:os";
import path from "node:path";
import { spawnSync } from "node:child_process";

const repoRoot = path.resolve(new URL("..", import.meta.url).pathname);
const pagesRoot = path.join(repoRoot, "revised/problems");
const outputRoot = path.join(repoRoot, "revised/revision-pdfs");
const publicProblemsBase = (process.env.REVISION_PDF_BASE_URL ?? "https://arvindkasale08.github.io/dsa-practice/revised/problems").replace(/\/$/, "");
const chromeCandidates = [
  process.env.CHROME_BIN,
  "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome",
  "/Applications/Chromium.app/Contents/MacOS/Chromium"
].filter(Boolean);

const pageNames = {
  fastslow: "fast-slow-pointers-revision.pdf",
  hashing: "hashing-revision.pdf",
  slidingwindow: "sliding-window-revision.pdf",
  stacks: "stacks-revision.pdf",
  twopointers: "two-pointers-revision.pdf",
  warmup: "warmup-revision.pdf"
};

function findChrome() {
  const chrome = chromeCandidates.find(candidate => fs.existsSync(candidate));
  if (!chrome) {
    throw new Error("Could not find Chrome. Set CHROME_BIN to a headless-capable browser executable.");
  }
  return chrome;
}

function discoverPatterns() {
  return fs
    .readdirSync(pagesRoot, { withFileTypes: true })
    .filter(entry => entry.isDirectory())
    .map(entry => entry.name)
    .filter(pattern => fs.existsSync(path.join(pagesRoot, pattern, "index.html")))
    .sort();
}

function fileUrl(filePath) {
  return `file://${filePath.split(path.sep).map(encodeURIComponent).join("/")}`;
}

function titleCase(value) {
  return value
    .replace(/[-_]+/g, " ")
    .replace(/([a-z])([A-Z])/g, "$1 $2")
    .replace(/\b\w/g, char => char.toUpperCase());
}

function pdfNameFor(pattern) {
  return pageNames[pattern] ?? `${pattern.replace(/[^a-z0-9]+/gi, "-").replace(/^-|-$/g, "").toLowerCase()}-revision.pdf`;
}

function makePrintableHtml(html, pattern) {
  const pageBase = `${publicProblemsBase}/${pattern}/`;
  return html
    .replace(/<head>/, `<head>\n  <base href="${pageBase}">`)
    .replace(/let quickMode = true;/, "let quickMode = false;")
    .replace(/<p class="subtitle">([\s\S]*?)<\/p>/, '<p class="subtitle">$1 Exported in expanded card mode.</p>');
}

function exportPattern(chrome, pattern, tempRoot) {
  const sourcePath = path.join(pagesRoot, pattern, "index.html");
  const outputPath = path.join(outputRoot, pdfNameFor(pattern));
  const tempPath = path.join(tempRoot, `${pattern}.html`);
  const userDataDir = path.join(tempRoot, `chrome-${pattern}`);
  const html = makePrintableHtml(fs.readFileSync(sourcePath, "utf8"), pattern);

  fs.writeFileSync(tempPath, html);
  fs.mkdirSync(outputRoot, { recursive: true });

  const result = spawnSync(chrome, [
    "--headless=new",
    "--disable-gpu",
    "--no-first-run",
    "--disable-background-networking",
    "--disable-component-update",
    "--disable-dev-shm-usage",
    "--disable-sync",
    "--metrics-recording-only",
    "--run-all-compositor-stages-before-draw",
    "--virtual-time-budget=1000",
    `--user-data-dir=${userDataDir}`,
    "--print-to-pdf-no-header",
    `--print-to-pdf=${outputPath}`,
    fileUrl(tempPath)
  ], { stdio: "pipe", timeout: 45000 });

  const pdfExists = fs.existsSync(outputPath) && fs.statSync(outputPath).size > 0;
  if (result.error && !(result.error.code === "ETIMEDOUT" && pdfExists)) {
    throw result.error;
  }
  if (result.status !== 0 && !pdfExists) {
    throw new Error(`Chrome failed for ${pattern}: ${result.stderr?.toString() || result.status}`);
  }

  return {
    pattern,
    title: titleCase(pattern),
    outputPath
  };
}

function main() {
  const chrome = findChrome();
  const patterns = process.argv.slice(2).length ? process.argv.slice(2) : discoverPatterns();
  const tempRoot = fs.mkdtempSync(path.join(os.tmpdir(), "dsa-revision-pdf-"));

  try {
    const exported = patterns.map(pattern => exportPattern(chrome, pattern, tempRoot));
    exported.forEach(item => {
      console.log(`Exported ${item.title}: ${path.relative(repoRoot, item.outputPath)}`);
    });
  } finally {
    fs.rmSync(tempRoot, { recursive: true, force: true });
  }
}

main();
