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
  },
  fastslow: {
    title: "Fast & Slow Pointers Revision",
    label: "fast & slow pointers",
    subtitle: "Fast recall cards for the current fast and slow pointers package. Picture the runner movement, then check the sample and bug magnets before opening the Java file."
  },
  slidingwindow: {
    title: "Sliding Window Revision",
    label: "sliding window",
    subtitle: "Fast recall cards for the current sliding window package. Picture the window boundary movement, then check the sample and bug magnets before opening the Java file."
  },
  recursion: {
    title: "Recursion Revision",
    label: "recursion",
    subtitle: "Fast recall cards for the current recursion package. Picture the base case, the smaller call, and the unwind before opening the Java file."
  },
  backtracking: {
    title: "Backtracking Revision",
    label: "backtracking",
    subtitle: "Fast recall cards for the current backtracking package. Picture the choice, the smaller recursive call, and the undo step before opening the Java file."
  },
  greedy: {
    title: "Greedy Revision",
    label: "greedy",
    subtitle: "Fast recall cards for the current greedy package. Look for the local choice that locks in the best outcome, then check the sample and bug magnets before opening the Java file."
  }
};

const ignoredJavaPackages = new Set(["common"]);
const requestedPatterns = process.argv.slice(2);
const patterns = requestedPatterns.length ? requestedPatterns : discoverPatterns();

function discoverPatterns() {
  const pagePatterns = fs
    .readdirSync(pagesRoot, { withFileTypes: true })
    .filter(entry => entry.isDirectory())
    .map(entry => entry.name)
    .filter(pattern => fs.existsSync(path.join(pagesRoot, pattern, "index.html")));

  const javaRoot = path.join(pagesRoot, "com/arvind/revision");
  const javaPatterns = fs.existsSync(javaRoot)
    ? fs
        .readdirSync(javaRoot, { withFileTypes: true })
        .filter(entry => entry.isDirectory())
        .map(entry => entry.name)
        .filter(pattern => !ignoredJavaPackages.has(pattern))
        .filter(pattern => fs.readdirSync(path.join(javaRoot, pattern)).some(file => file.endsWith(".java")))
    : [];

  return Array.from(new Set([...pagePatterns, ...javaPatterns])).sort();
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

function javaClassesFor(pattern) {
  const javaDir = path.join(pagesRoot, "com/arvind/revision", pattern);
  if (!fs.existsSync(javaDir)) return [];
  return fs
    .readdirSync(javaDir, { withFileTypes: true })
    .filter(entry => entry.isFile() && entry.name.endsWith(".java"))
    .map(entry => entry.name.replace(/\.java$/, ""))
    .sort((left, right) => {
      const leftStat = fs.statSync(path.join(javaDir, `${left}.java`));
      const rightStat = fs.statSync(path.join(javaDir, `${right}.java`));
      return leftStat.birthtimeMs - rightStat.birthtimeMs || left.localeCompare(right);
    });
}

function defaultCardFor(pattern, className) {
  const source = `../com/arvind/revision/${pattern}/${className}.java`;
  const generic = {
    name: className,
    source,
    label: "Classify the local best move",
    difficulty: "Medium",
    leetcode: "",
    description: "Practice problem from this package. Read the class name, source, and sample, then recall the smallest local decision that makes the solution work.",
    time: "See source",
    space: "See source",
    timeWhy: "Confirm from the final implementation after solving.",
    structures: "See source",
    input: "see main method",
    output: "see main method",
    recognize: "When the problem can be solved by repeatedly making a locally best choice that does not need to be undone later.",
    visual: [["state", "best local choice", "answer"]],
    visualText: "Picture scanning the input and keeping just enough state to preserve the best local decision so far.",
    core: "Identify the local rule, keep the minimum state needed for that rule, and update the answer without revisiting earlier choices.",
    bruteForce: "Try every possible choice combination and keep the best valid result. This is useful as a correctness baseline but usually too slow.",
    alternates: ["Sorting can make greedy choices obvious when relative order does not matter."],
    gotchas: ["Prove the local choice cannot block a better future answer."]
  };

  if (className === "BuyTwoChocolates") {
    return {
      name: className,
      source,
      label: "Keep the two cheapest prices",
      difficulty: "Easy",
      leetcode: "https://leetcode.com/problems/buy-two-chocolates/",
      description: "Given chocolate prices and starting money, buy exactly two chocolates if the two cheapest fit in the budget. Return leftover money after buying them, otherwise return the original money.",
      time: "O(n)",
      space: "O(1)",
      timeWhy: "One scan is enough because only the cheapest and second-cheapest prices matter.",
      structures: "two minimum trackers",
      input: "prices = [1, 2, 2], money = 3",
      output: "0",
      recognize: "When you only need the best two individual costs, not the actual pair order or all combinations.",
      visual: [
        ["price 1", "min1 = 1", "min2 = inf"],
        ["price 2", "min1 = 1", "min2 = 2"],
        ["1 + 2 <= 3", "buy", "left 0"]
      ],
      visualText: "Picture two baskets: cheapest goes in the first basket, second-cheapest goes in the second basket. Every new price tries to enter one of those baskets.",
      core: "Scan once. If a price is smaller than the cheapest, shift old cheapest to second-cheapest. Otherwise only update second-cheapest. At the end, buy only if min1 + min2 fits the budget.",
      bruteForce: "Check every pair of chocolates, compute the cheapest valid pair, then return the leftover. This is O(n^2) and unnecessary because only the two smallest prices matter.",
      alternates: [
        "Sort the prices and check the first two. It is simple but costs O(n log n).",
        "A min-heap can pull two cheapest values, but it uses extra space and is heavier than two variables."
      ],
      gotchas: [
        "When a new smallest price appears, move the old smallest into second place before replacing it.",
        "If the cheapest two exceed the budget, return the original money, not a negative leftover."
      ]
    };
  }

  return generic;
}

function defaultDetailsFor(pattern, className) {
  if (className === "BuyTwoChocolates") {
    return {
      prompt: "Before reading: what two values are enough to decide whether buying is possible?",
      steps: [
        "Keep the cheapest and second-cheapest prices while scanning.",
        "A new cheapest pushes the old cheapest into second place.",
        "A price that is not cheapest may still improve second-cheapest.",
        "Return leftover only when the two cheapest fit the budget."
      ],
      skeleton: "scan prices\n  update cheapest and second-cheapest\n\ncost = cheapest + secondCheapest\nif cost <= money\n  return money - cost\nreturn money"
    };
  }

  return {
    prompt: "Before reading: what local choice is safe to commit to?",
    steps: [
      "Identify the locally best candidate.",
      "Keep only the state required to compare future candidates.",
      "Update the answer as the scan progresses.",
      "Return the greedy result after validating edge cases."
    ],
    skeleton: "scan input\n  update local best state\n  preserve answer condition\n\nreturn final answer"
  };
}

function defaultDefiningMoveFor(pattern, className) {
  if (className === "BuyTwoChocolates") {
    return "Track min1 and min2 in one scan\nnew min1 shifts old min1 to min2\nbuy only if min1 + min2 <= money";
  }
  return "Find the safe local choice\nkeep minimal comparison state\ncommit without backtracking";
}

function makeDataBlocksForNewPattern(pattern) {
  const classes = javaClassesFor(pattern);
  const cards = classes.map(className => defaultCardFor(pattern, className));
  const recallDetails = Object.fromEntries(classes.map(className => [className, defaultDetailsFor(pattern, className)]));
  const definingMoves = Object.fromEntries(classes.map(className => [className, defaultDefiningMoveFor(pattern, className)]));

  return {
    cards: `const cards = ${JSON.stringify(cards, null, 6)};`,
    recallDetails: `const recallDetails = ${JSON.stringify(recallDetails, null, 6)};`,
    definingMoves: `const definingMoves = ${JSON.stringify(definingMoves, null, 6)};`,
    solvedOrder: `const solvedOrder = ${JSON.stringify(classes, null, 6)};`
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
    const dataBlocks = fs.existsSync(pagePath)
      ? extractDataBlocks(readPage(pattern))
      : makeDataBlocksForNewPattern(pattern);
    const nextHtml = renderFromCanonical(canonicalTemplate, dataBlocks, pattern);
    writePage(pattern, nextHtml);
    console.log(`Generated ${path.relative(repoRoot, pagePath)}`);
  }
}

main();
