#!/usr/bin/env node

import fs from "node:fs";
import path from "node:path";

const repoRoot = path.resolve(new URL("..", import.meta.url).pathname);
const pagesRoot = path.join(repoRoot, "revised/problems");
const canonicalPattern = "stacks";

const pageConfigs = {
  warmup: {
    title: "Warmup Revision",
    label: "warmup",
    subtitle: "Fast recall cards for the completed warmup package. Read the problem name, picture the hook, then check the sample and bug magnets before opening the Java file."
  },
  twopointers: {
    title: "Two Pointers Revision",
    label: "two pointers",
    subtitle: "Fast recall cards for the current two pointers package. Read the problem name, picture the pointer movement, then check the sample and bug magnets before opening the Java file."
  },
  stacks: {
    title: "Stacks Revision",
    label: "stacks",
    subtitle: "Fast recall cards for the current stacks package. Read the problem name, picture the hook, then check the sample and bug magnets before opening the Java file."
  },
  hashing: {
    title: "Hashing Revision",
    label: "hashing",
    subtitle: "Fast recall cards for the current hashing package. Use Quick Review first, then expand a row when you need the full explanation."
  }
};

const requestedPatterns = process.argv.slice(2);
const patterns = requestedPatterns.length ? requestedPatterns : discoverPatterns();

function discoverPatterns() {
  return fs
    .readdirSync(pagesRoot, { withFileTypes: true })
    .filter(entry => entry.isDirectory())
    .map(entry => entry.name)
    .filter(pattern => fs.existsSync(path.join(pagesRoot, pattern, "index.html")))
    .sort();
}

function readPage(pattern) {
  return fs.readFileSync(path.join(pagesRoot, pattern, "index.html"), "utf8");
}

function writePage(pattern, html) {
  fs.mkdirSync(path.join(pagesRoot, pattern), { recursive: true });
  fs.writeFileSync(path.join(pagesRoot, pattern, "index.html"), html);
}

function findAssignmentBlock(html, name) {
  const assignment = `const ${name} =`;
  const assignmentIndex = html.indexOf(assignment);
  if (assignmentIndex === -1) {
    throw new Error(`Could not find ${assignment}`);
  }

  const start = html.indexOf(html.slice(assignmentIndex).match(/[\[{]/)?.[0] ?? "", assignmentIndex);
  if (start === -1) {
    throw new Error(`Could not find literal start for ${name}`);
  }

  const opener = html[start];
  const closer = opener === "[" ? "]" : "}";
  let depth = 0;
  let quote = "";
  let escaped = false;
  let inLineComment = false;
  let inBlockComment = false;

  for (let index = start; index < html.length; index += 1) {
    const char = html[index];
    const next = html[index + 1];

    if (inLineComment) {
      if (char === "\n") inLineComment = false;
      continue;
    }

    if (inBlockComment) {
      if (char === "*" && next === "/") {
        inBlockComment = false;
        index += 1;
      }
      continue;
    }

    if (quote) {
      if (escaped) {
        escaped = false;
      } else if (char === "\\") {
        escaped = true;
      } else if (char === quote) {
        quote = "";
      }
      continue;
    }

    if (char === "/" && next === "/") {
      inLineComment = true;
      index += 1;
      continue;
    }

    if (char === "/" && next === "*") {
      inBlockComment = true;
      index += 1;
      continue;
    }

    if (char === "\"" || char === "'" || char === "`") {
      quote = char;
      continue;
    }

    if (char === opener) depth += 1;
    if (char === closer) depth -= 1;

    if (depth === 0) {
      const semicolon = html.indexOf(";", index);
      if (semicolon === -1) {
        throw new Error(`Could not find semicolon for ${name}`);
      }
      return html.slice(assignmentIndex, semicolon + 1);
    }
  }

  throw new Error(`Could not close literal for ${name}`);
}

function replaceAssignmentBlock(html, name, replacement) {
  const current = findAssignmentBlock(html, name);
  return html.replace(current, replacement);
}

function extractDataBlocks(html) {
  return {
    cards: findAssignmentBlock(html, "cards"),
    recallDetails: findAssignmentBlock(html, "recallDetails"),
    definingMoves: findAssignmentBlock(html, "definingMoves"),
    solvedOrder: findAssignmentBlock(html, "solvedOrder")
  };
}

function titleCaseFromPattern(pattern) {
  return pattern
    .replace(/[-_]+/g, " ")
    .replace(/\b\w/g, char => char.toUpperCase());
}

function identityFor(pattern) {
  const fallbackTitle = `${titleCaseFromPattern(pattern)} Revision`;
  return pageConfigs[pattern] ?? {
    title: fallbackTitle,
    label: pattern.replace(/[-_]+/g, " "),
    subtitle: `Fast recall cards for the current ${pattern.replace(/[-_]+/g, " ")} package. Read the problem name, picture the hook, then check the sample and bug magnets before opening the Java file.`
  };
}

function applyIdentity(html, pattern) {
  const identity = identityFor(pattern);
  const label = identity.label;

  return html
    .replace(/<title>.*?<\/title>/, `<title>${identity.title}</title>`)
    .replace(/<h1>.*?<\/h1>/, `<h1>${identity.title}</h1>`)
    .replace(/placeholder="Search .*? cards"/, `placeholder="Search ${label} cards"`)
    .replace(/<div id="empty" class="empty">.*?<\/div>/, `<div id="empty" class="empty">No matching ${label} cards.</div>`)
    .replace(/<p class="subtitle">[\s\S]*?<\/p>/, `<p class="subtitle">${identity.subtitle}</p>`)
    .replace(/dsa-revision:[^:$`]+:\$\{cardName\}/g, `dsa-revision:${pattern}:\${cardName}`)
    .replace(/Reset revision counts and dates for all .*? problems\?/g, `Reset revision counts and dates for all ${label} problems?`)
    .replace(/totalCountEl\.textContent = `\$\{cards\.length\} problems`;/, 'totalCountEl.textContent = `${cards.length} problem${cards.length === 1 ? "" : "s"}`;');
}

function renderFromCanonical(template, dataBlocks, pattern) {
  let output = template;
  output = applyIdentity(output, pattern);
  output = replaceAssignmentBlock(output, "cards", dataBlocks.cards);
  output = replaceAssignmentBlock(output, "recallDetails", dataBlocks.recallDetails);
  output = replaceAssignmentBlock(output, "definingMoves", dataBlocks.definingMoves);
  output = replaceAssignmentBlock(output, "solvedOrder", dataBlocks.solvedOrder);
  return output;
}

function main() {
  const canonicalTemplate = readPage(canonicalPattern);

  for (const pattern of patterns) {
    const pagePath = path.join(pagesRoot, pattern, "index.html");
    if (!fs.existsSync(pagePath)) {
      throw new Error(`No revision page exists yet for ${pattern}: ${pagePath}`);
    }
    const currentHtml = readPage(pattern);
    const dataBlocks = extractDataBlocks(currentHtml);
    const nextHtml = renderFromCanonical(canonicalTemplate, dataBlocks, pattern);
    writePage(pattern, nextHtml);
    console.log(`Generated ${path.relative(repoRoot, pagePath)}`);
  }
}

main();
