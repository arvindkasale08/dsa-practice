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
  },
  graphs: {
    title: "Graphs Revision",
    label: "graphs",
    subtitle: "Reference notes for graph fundamentals and Java representation. Open the linked workbook notes or visual guide when revising."
  }
};

const ignoredJavaPackages = new Set(["common"]);
const ignoredJavaClasses = new Set([
  "greedy/RemoveDuplicateLetters"
]);
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

function valueFromAssignmentBlock(html, name) {
  const block = findAssignmentBlock(html, name);
  return Function(`${block}\nreturn ${name};`)();
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
    .filter(className => !ignoredJavaClasses.has(`${pattern}/${className}`))
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

  if (className === "AssignCookies") {
    return {
      name: className,
      source,
      label: "Give smallest fitting cookie",
      difficulty: "Easy",
      leetcode: "https://leetcode.com/problems/assign-cookies/",
      description: "Given children with greed values and cookies with sizes, maximize how many children become content. A child is content when assigned one cookie whose size is at least that child's greed.",
      time: "O(n log n + m log m)",
      space: "O(1)",
      timeWhy: "Both arrays are sorted first. After that, each child and cookie pointer moves at most once.",
      structures: "sorted arrays, two pointers",
      input: "g = [1, 2, 3], s = [1, 1]",
      output: "1",
      recognize: "When each resource can satisfy at most one demand and using a bigger resource on a smaller demand can waste future options.",
      visual: [
        ["small kid", "small cookie", "fit?"],
        ["fit", "count + 1", "move both"],
        ["no fit", "try bigger cookie", "keep kid"]
      ],
      visualText: "Picture children and cookies standing in two sorted lines. Always try to satisfy the easiest remaining child with the smallest cookie that can work.",
      core: "Sort greed and cookie sizes. Use two pointers. If the current cookie satisfies the current child, count it and move both. If not, discard that cookie by moving only the cookie pointer.",
      bruteForce: "Try assigning every cookie to every child and keep the best matching. That wastes time because sorting exposes the safest smallest-fit choice.",
      alternates: [
        "Scan from largest child to largest cookie instead. The idea is the same: use the smallest sufficient resource for each demand directionally.",
        "A multiset can find the smallest cookie >= greed, but sorting with two pointers is simpler."
      ],
      gotchas: [
        "Do not give a large cookie to an easy child if a smaller cookie can satisfy them.",
        "A cookie can be used once, and a child can receive at most one cookie."
      ]
    };
  }

  if (className === "LemonadeChange") {
    return {
      name: className,
      source,
      label: "Preserve customer order",
      difficulty: "Easy",
      leetcode: "https://leetcode.com/problems/lemonade-change/",
      description: "Customers pay for $5 lemonade using $5, $10, or $20 bills. Starting with no change, return whether every customer can be served in the exact arrival order.",
      time: "O(n)",
      space: "O(1)",
      timeWhy: "Each bill is processed once, and only counts of available $5 and $10 bills are needed.",
      structures: "two counters for $5 and $10 bills",
      input: "bills = [5, 5, 5, 20, 10, 10]",
      output: "false",
      recognize: "When transactions must happen in queue order and every decision depends on the change you currently hold.",
      visual: [
        ["$5", "keep five", "five = 1"],
        ["$10", "give $5", "ten = 1"],
        ["$20", "prefer $10+$5", "save $5s"]
      ],
      visualText: "Picture a cash drawer with only two slots: $5 bills and $10 bills. Every customer changes the drawer before the next one arrives.",
      core: "Scan bills in original order. For $5, collect it. For $10, spend one $5 and collect one $10. For $20, prefer giving $10 + $5; if not possible, give three $5 bills.",
      bruteForce: "Try simulating all possible change choices for each $20. This is unnecessary because using $10 + $5 first preserves more $5 bills for future $10 customers.",
      alternates: [
        "For $20, giving three $5 bills also works only when no $10 bill is available.",
        "A cash-count map is more general, but two integer counters are simpler because only $5 and $10 change matter."
      ],
      gotchas: [
        "Do not sort the bills. The queue order is part of the problem.",
        "A $20 customer needs $15 change, preferably one $10 and one $5.",
        "If a counter goes negative, fail immediately."
      ]
    };
  }

  if (className === "ValidParanthesisString") {
    return {
      name: className,
      source,
      label: "Track possible open range",
      difficulty: "Medium",
      leetcode: "https://leetcode.com/problems/valid-parenthesis-string/",
      description: "Given a string containing '(', ')' and '*', decide if it can become a valid parenthesis string. Each '*' can act as '(', ')' or an empty character.",
      time: "O(n)",
      space: "O(1)",
      timeWhy: "Each character updates the possible range of unmatched opens once.",
      structures: "min/max open counters",
      input: "s = \"(*))\"",
      output: "true",
      recognize: "When '*' creates several possible states, but you only need the minimum and maximum possible unmatched '(' count.",
      visual: [
        ["(", "min=1", "max=1"],
        ["*", "min can drop", "max can rise"],
        [")", "both drop", "max must stay >= 0"]
      ],
      visualText: "Picture carrying a rubber band of possible open counts. `minOpen` is the lowest possible opens, `maxOpen` is the highest possible opens.",
      core: "Scan left to right. '(' increases both bounds. ')' decreases both bounds. '*' lowers the minimum and raises the maximum. Clamp the minimum to zero, and fail if the maximum drops below zero.",
      bruteForce: "Try all three meanings for every '*'. This is useful for understanding but becomes O(3^stars).",
      alternates: [
        "Use two stacks of indexes for '(' and '*', then pair leftover '(' only with later '*'.",
        "Use recursion with memoization on index and balance; clearer for state exploration but heavier than the greedy range."
      ],
      gotchas: [
        "Clamp minOpen to zero after it decreases; negative minimum only means choose empty instead.",
        "Check maxOpen after consuming a ')'. If it is negative, no interpretation can save the prefix.",
        "Valid at the end means minOpen is zero, not necessarily maxOpen."
      ]
    };
  }

  if (className === "CanPlaceFlowers") {
    return {
      name: className,
      source,
      label: "Plant earliest safe spot",
      difficulty: "Easy",
      leetcode: "https://leetcode.com/problems/can-place-flowers/",
      description: "Given a flowerbed of 0s and 1s, decide whether n new flowers can be planted without placing flowers in adjacent plots.",
      time: "O(n)",
      space: "O(1)",
      timeWhy: "Each plot is inspected once, and planting in place updates the state for the next plot.",
      structures: "array scan, boundary checks",
      input: "flowerbed = [0, 0, 1, 0, 0, 0, 1, 0, 0], n = 2",
      output: "true",
      recognize: "When choosing the earliest valid placement cannot reduce the maximum number of future placements.",
      visual: [
        ["left", "plot", "right"],
        ["0", "0", "0"],
        ["plant", "mark 1", "continue"]
      ],
      visualText: "Picture a three-cell window. If left, current, and right are all empty, plant immediately and the array itself remembers the decision.",
      core: "Scan left to right. Treat outside boundaries as empty. If left/current/right are all 0, plant at current by writing 1 and reduce n. At the end, check whether n is zero or less.",
      bruteForce: "Try all combinations of empty plots and test adjacency. That is unnecessary because the earliest safe placement never blocks a better total.",
      alternates: [
        "Count lengths of zero-runs and compute capacity mathematically, but direct scanning is easier and less bug-prone.",
        "Skip the next index after planting as a small optimization, since it cannot be planted."
      ],
      gotchas: [
        "Boundary plots only have one neighbor, so treat the missing neighbor as empty.",
        "Mutating flowerbed is fine for this problem, but remember it changes later neighbor checks.",
        "Return true as soon as n reaches zero if you want an early exit."
      ]
    };
  }

  if (className === "MinimumAddToMakeParenthesisValid") {
    return {
      name: className,
      source,
      label: "Pay for unmatched brackets",
      difficulty: "Medium",
      leetcode: "https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/",
      description: "Given a parentheses string, return the minimum number of parentheses you must add so every closing bracket has a matching earlier opening bracket and every opening bracket is eventually closed.",
      time: "O(n)",
      space: "O(1)",
      timeWhy: "Each character is scanned once and only two counters are updated.",
      structures: "open counter, additions counter",
      input: "s = \"))((\"",
      output: "4",
      recognize: "When the question asks how many brackets are missing, not whether the string can be rearranged or deleted.",
      visual: [
        [")", "no open", "add '('"],
        ["(", "open++", "wait"],
        [")", "match open", "open--"]
      ],
      visualText: "Picture unmatched ')' as immediate bills you must pay, while unmatched '(' are pending doors that need closers at the end.",
      core: "Scan left to right. Count unmatched '(' as open. When ')' appears, consume one open if possible; otherwise count one required added '('. After the scan, every remaining open needs one added ')'.",
      bruteForce: "Try inserting parentheses in different positions until the string becomes valid. That proves the meaning but is far more work than counting exactly what is missing.",
      alternates: [
        "Use a stack and push unmatched parentheses, then return stack size; simple but uses O(n) space.",
        "This is a smaller sibling of wildcard parentheses problems because there is no '*' flexibility."
      ],
      gotchas: [
        "An unmatched ')' must be counted immediately; a later '(' cannot fix an earlier close.",
        "Do not forget to add leftover open count after the scan.",
        "This is add-to-valid, not remove-to-valid; the answer is a count, not a rebuilt string."
      ]
    };
  }

  if (className === "ValidPalindromeII") {
    return {
      name: className,
      source,
      label: "One deletion fork",
      difficulty: "Easy",
      leetcode: "https://leetcode.com/problems/valid-palindrome-ii/",
      description: "Given a string, return whether it is already a palindrome or can become one after deleting at most one character.",
      time: "O(n)",
      space: "O(1)",
      timeWhy: "The main two-pointer scan moves inward once. At the first mismatch, at most two remaining substrings are checked linearly.",
      structures: "two pointers, bounded helper scan",
      input: "s = \"cbbcc\"",
      output: "true",
      recognize: "When a palindrome check allows one mistake, so the first mismatch is the only moment where you get to spend the deletion.",
      visual: [
        ["c", "b", "b", "c", "c"],
        ["match ends", "move in", "b vs c mismatch"],
        ["skip left OR skip right", "one must finish", "true/false"]
      ],
      visualText: "Picture two fingers walking inward. When they disagree, you get one coupon: remove the left char or remove the right char, then the rest must be a clean palindrome.",
      core: "Use two pointers from both ends. While characters match, move inward. On the first mismatch, check both possible remaining ranges: skip the left character, or skip the right character. If either range is a palindrome, return true.",
      bruteForce: "Delete every index one by one and test whether the remaining string is a palindrome. That is O(n^2) because each deletion can require a full scan.",
      alternates: [
        "Recursive version with a deletion count works, but it is heavier than the two helper checks.",
        "Building new strings after deletion is simpler to visualize but wastes O(n) space per attempt."
      ],
      gotchas: [
        "Do not choose the skip side only from the next immediate character; try both sides.",
        "Only one mismatch can spend the deletion. The helper check should be a plain palindrome check.",
        "Use indexes for the helper so no new string is needed."
      ]
    };
  }

  if (className === "MaximumLengthOfPairChains") {
    return {
      name: className,
      source,
      label: "Finish earliest interval",
      difficulty: "Medium",
      leetcode: "https://leetcode.com/problems/maximum-length-of-pair-chain/",
      description: "Given pairs [left, right], choose the longest chain where each next pair must start after the previous pair ends. You can reorder pairs and do not need to use all of them.",
      time: "O(n log n)",
      space: "O(1)",
      timeWhy: "Sorting by right endpoint dominates. After sorting, one scan decides whether to take or skip each pair.",
      structures: "sorted intervals, last selected end",
      input: "pairs = [[1, 2], [2, 3], [3, 4]]",
      output: "2",
      recognize: "When you need the maximum number of non-overlapping intervals and the only thing that matters for the future is how early the current choice ends.",
      visual: [
        ["[1,2]", "ends early", "take"],
        ["[2,3]", "2 is not > 2", "skip"],
        ["[3,4]", "3 > 2", "take"]
      ],
      visualText: "Picture each pair as a meeting slot. Taking the meeting that ends earliest leaves the most room for whatever comes next.",
      core: "Sort pairs by their right value. Keep the right value of the last selected pair. For each pair, take it only if its left value is greater than the last selected right value, then update the last right.",
      bruteForce: "Try every subset/order of pairs and check valid chains. That explodes because each pair can be chosen or skipped in many orders.",
      alternates: [
        "Dynamic programming after sorting by start or end can compute the longest chain, but it is O(n^2) and unnecessary here.",
        "This is the same shape as activity selection: choose the interval that frees the timeline earliest."
      ],
      gotchas: [
        "The rule is strict: next left must be greater than previous right, not greater than or equal.",
        "Sort by end, not start. Early start can block a shorter interval that ends sooner.",
        "Initialize lastRight below every possible value so the first selected pair is allowed."
      ]
    };
  }

  if (className === "Candy") {
    return {
      name: className,
      source,
      label: "Satisfy both neighbor directions",
      difficulty: "Hard",
      leetcode: "https://leetcode.com/problems/candy/",
      description: "Given children ratings, give each child at least one candy. Any child with a higher rating than an adjacent child must receive more candy than that neighbor. Return the minimum total candies.",
      time: "O(n)",
      space: "O(n)",
      timeWhy: "One left-to-right pass satisfies increasing slopes from the left, one right-to-left pass fixes decreasing slopes from the right, then one sum pass totals candies.",
      structures: "candies array, two directional passes",
      input: "ratings = [1, 3, 2, 2, 1]",
      output: "7",
      recognize: "When each position must satisfy local constraints against both left and right neighbors.",
      visual: [
        ["left pass", "1 < 3", "raise right"],
        ["right pass", "2 > 1", "raise left"],
        ["merge", "take max", "minimum valid"]
      ],
      visualText: "Picture two waves. The left wave handles children higher than the left neighbor; the right wave handles children higher than the right neighbor.",
      core: "Start every child with one candy. Sweep left to right and increase candy when rating rises from the left. Sweep right to left and use max when rating rises from the right. Sum the final candies.",
      bruteForce: "Repeatedly adjust candies until all neighbor rules are satisfied. It works as a mental model but can revisit positions many times.",
      alternates: [
        "Use slope counting to solve in O(1) extra space, but it is harder to remember.",
        "Priority queue by rating can assign lower-rated children first, but it is O(n log n) and more machinery."
      ],
      gotchas: [
        "Equal ratings do not require more candy.",
        "The right pass must use max, otherwise it can destroy a value already needed by the left pass.",
        "Initialize every child with one candy before enforcing neighbor rules."
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

  if (className === "AssignCookies") {
    return {
      prompt: "Before reading: why is the smallest sufficient cookie the safest gift?",
      steps: [
        "Sort children by greed and cookies by size.",
        "Try to satisfy the current easiest child with the current smallest cookie.",
        "If it fits, count one content child and move both pointers.",
        "If it does not fit, that cookie cannot help this child or any greedier child, so skip only the cookie."
      ],
      skeleton: "sort greed\nsort cookies\nchild = 0, cookie = 0\nwhile child and cookie are in range\n  if cookie fits child\n    answer++\n    child++\n  cookie++\nreturn answer"
    };
  }

  if (className === "LemonadeChange") {
    return {
      prompt: "Before reading: why would sorting customers change the problem?",
      steps: [
        "Keep counts of $5 and $10 bills in the drawer.",
        "Process each bill in arrival order; never rearrange customers.",
        "For $20, use $10 + $5 first because it saves more $5 bills.",
        "Return false as soon as required change cannot be made."
      ],
      skeleton: "five = 0, ten = 0\nfor bill in original order\n  if bill is 5: five++\n  if bill is 10: five--, ten++\n  if bill is 20:\n    if ten > 0: ten--, five--\n    else: five -= 3\n  if five < 0 or ten < 0: return false\nreturn true"
    };
  }

  if (className === "ValidParanthesisString") {
    return {
      prompt: "Before reading: what range of open counts can '*' create?",
      steps: [
        "Keep minOpen and maxOpen as the possible unmatched '(' range.",
        "'(' shifts the whole range up.",
        "')' shifts the whole range down and fails if maxOpen becomes negative.",
        "'*' can be ')', empty, or '(', so widen the range and clamp minOpen to zero."
      ],
      skeleton: "minOpen = 0, maxOpen = 0\nfor each char\n  update minOpen and maxOpen by char type\n  if maxOpen < 0: return false\n  minOpen = max(0, minOpen)\nreturn minOpen == 0"
    };
  }

  if (className === "CanPlaceFlowers") {
    return {
      prompt: "Before reading: why is planting at the first safe empty plot never harmful?",
      steps: [
        "Scan each plot with its left and right neighbors.",
        "Treat missing boundary neighbors as empty.",
        "If left, current, and right are all empty, plant immediately.",
        "Mark the current plot as planted so the next check sees the updated bed."
      ],
      skeleton: "for each index\n  left = boundary ? 0 : flowerbed[i - 1]\n  right = boundary ? 0 : flowerbed[i + 1]\n  if left == 0 and current == 0 and right == 0\n    flowerbed[i] = 1\n    n--\nreturn n <= 0"
    };
  }

  if (className === "MinimumAddToMakeParenthesisValid") {
    return {
      prompt: "Before reading: which invalid bracket must be paid for immediately, and which can wait until the end?",
      steps: [
        "Carry open = unmatched '(' waiting for closers.",
        "For '(', increase open.",
        "For ')', consume open if one exists.",
        "If ')' has no open to consume, add one missing '(' to the answer.",
        "After the scan, add all leftover open because each needs a ')'."
      ],
      skeleton: "open = 0, add = 0\nfor char in s\n  if char is '(':\n    open++\n  else if open > 0:\n    open--\n  else:\n    add++\nreturn add + open"
    };
  }

  if (className === "ValidPalindromeII") {
    return {
      prompt: "Before reading: when the two ends mismatch, which side are you allowed to delete?",
      steps: [
        "Walk inward while the two ends match.",
        "At the first mismatch, spend the one deletion in exactly two possible ways.",
        "Check the remaining range after skipping left.",
        "Check the remaining range after skipping right.",
        "If either check succeeds, the original string can be saved."
      ],
      skeleton: "left = 0, right = n - 1\nwhile left < right\n  if chars match: move both inward\n  else:\n    return isPalindrome(left + 1, right) OR isPalindrome(left, right - 1)\nreturn true"
    };
  }

  if (className === "MaximumLengthOfPairChains") {
    return {
      prompt: "Before reading: why is the pair that ends earliest the safest one to keep?",
      steps: [
        "Sort all pairs by their right endpoint.",
        "Keep the right endpoint of the last pair you accepted.",
        "If the next pair starts after that endpoint, accept it.",
        "If it overlaps or just touches, skip it because it would not extend the chain.",
        "Count accepted pairs."
      ],
      skeleton: "sort pairs by end\nlastRight = very small\ncount = 0\nfor pair in sorted pairs\n  if pair.left > lastRight\n    count++\n    lastRight = pair.right\nreturn count"
    };
  }

  if (className === "Candy") {
    return {
      prompt: "Before reading: why does one pass see only half of the neighbor rules?",
      steps: [
        "Give every child one candy first.",
        "Left pass handles ratings[i] > ratings[i - 1].",
        "Right pass handles ratings[i] > ratings[i + 1].",
        "Use max on the right pass so both directions stay satisfied."
      ],
      skeleton: "candies = all 1\nleft to right\n  if rating rises from left\n    candies[i] = candies[i-1] + 1\nright to left\n  if rating rises from right\n    candies[i] = max(candies[i], candies[i+1] + 1)\nreturn sum(candies)"
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
  if (className === "AssignCookies") {
    return "Sort both arrays\nsmallest cookie tries easiest child\nfit moves both, miss moves cookie only";
  }
  if (className === "LemonadeChange") {
    return "Process bills in original queue order\n$20 prefers $10 + $5\nfail the moment change goes negative";
  }
  if (className === "ValidParanthesisString") {
    return "Carry possible open-count range\n'*' widens min/max\nfail if maxOpen goes negative";
  }
  if (className === "CanPlaceFlowers") {
    return "Check left-current-right window\nplant immediately when all empty\nwrite 1 so next plot is blocked";
  }
  if (className === "MinimumAddToMakeParenthesisValid") {
    return "Unmatched ')' adds one immediately\nunmatched '(' stays as open\nanswer is additions + leftover open";
  }
  if (className === "ValidPalindromeII") {
    return "At first mismatch, branch only once\nskip left OR skip right\nremaining range must be a clean palindrome";
  }
  if (className === "MaximumLengthOfPairChains") {
    return "Sort by smallest right endpoint\ntake pair only when left > lastRight\nending early leaves maximum room";
  }
  if (className === "Candy") {
    return "Left pass fixes left-neighbor rises\nright pass fixes right-neighbor rises\nmerge with max";
  }
  return "Find the safe local choice\nkeep minimal comparison state\ncommit without backtracking";
}

const authoredCardOverrides = new Set([
  "greedy/MinimumAddToMakeParenthesisValid",
  "greedy/ValidPalindromeII",
  "greedy/MaximumLengthOfPairChains"
]);

function makeDataBlocksForPattern(pattern, html = "") {
  const classes = javaClassesFor(pattern);
  const existingCards = html ? valueFromAssignmentBlock(html, "cards") : [];
  const existingNames = new Set(existingCards.map(card => card.name));
  const missingClasses = classes.filter(className => !existingNames.has(className));
  const overrideClasses = classes.filter(className => authoredCardOverrides.has(`${pattern}/${className}`));
  if (html && missingClasses.length === 0 && overrideClasses.length === 0) {
    return extractDataBlocks(html);
  }

  const recallDetails = html ? valueFromAssignmentBlock(html, "recallDetails") : {};
  const definingMoves = html ? valueFromAssignmentBlock(html, "definingMoves") : {};
  const existingOrder = html ? valueFromAssignmentBlock(html, "solvedOrder") : [];
  const overrideNames = new Set(overrideClasses);
  const cards = [
    ...existingCards.map(card => overrideNames.has(card.name) ? defaultCardFor(pattern, card.name) : card),
    ...missingClasses.map(className => defaultCardFor(pattern, className))
  ];

  for (const className of classes) {
    if (overrideNames.has(className)) {
      recallDetails[className] = defaultDetailsFor(pattern, className);
      definingMoves[className] = defaultDefiningMoveFor(pattern, className);
    } else {
      recallDetails[className] ??= defaultDetailsFor(pattern, className);
      definingMoves[className] ??= defaultDefiningMoveFor(pattern, className);
    }
  }

  const existingOrderSet = new Set(existingOrder);
  const solvedOrder = [
    ...existingOrder,
    ...classes.filter(className => !existingOrderSet.has(className)),
    ...cards.map(card => card.name).filter(name => !existingOrderSet.has(name) && !classes.includes(name))
  ];

  return {
    cards: `const cards = ${JSON.stringify(cards, null, 6)};`,
    recallDetails: `const recallDetails = ${JSON.stringify(recallDetails, null, 6)};`,
    definingMoves: `const definingMoves = ${JSON.stringify(definingMoves, null, 6)};`,
    solvedOrder: `const solvedOrder = ${JSON.stringify(solvedOrder, null, 6)};`
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
    const currentHtml = fs.existsSync(pagePath) ? readPage(pattern) : "";
    const dataBlocks = makeDataBlocksForPattern(pattern, currentHtml);
    const nextHtml = renderFromCanonical(canonicalTemplate, dataBlocks, pattern);
    writePage(pattern, nextHtml);
    console.log(`Generated ${path.relative(repoRoot, pagePath)}`);
  }
}

main();
