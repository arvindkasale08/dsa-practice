# DSA Revision Workspace Handoff

## Start Here

This file is the operating context for continuing Arvind's DSA revision work in a new Codex chat.

Workspace root:

`/Users/arvindkasale/arvind/work/dsa-practice`

Revision root:

`/Users/arvindkasale/arvind/work/dsa-practice/revised`

Important local pages:

- Cards home: `http://127.0.0.1:8771/problems/`
- Progress dashboard: `http://127.0.0.1:8771/progress/`
- Graph cards: `http://127.0.0.1:8771/problems/graphs/`

Start the local server with:

`python3 -m http.server 8771 --directory /Users/arvindkasale/arvind/work/dsa-practice/revised`

Before editing, inspect the repository and both packaged skill files. Existing code and generated pages are authoritative when this summary and the repository differ.

## Sync Cards Contract

When Arvind says **sync cards**:

1. Discover eligible Java classes across every revision package, not only the package open in the browser.
2. Create or update the corresponding package card pages.
3. Create a package HTML page when a newly added package does not have one.
4. Update the global problems index and progress dashboard.
5. Validate generated links, interactions, layout, and the local server page.
6. Report the number of newly synced problem cards and the updated daily count.
7. Do not generate PDFs or upload to Drive during routine syncing.
8. Do not pull from Git before syncing.
9. Commit the intended sync changes and push the current branch after validation; `sync cards` itself is standing authorization for this Git step.
10. Do not alter Java solution logic as part of card syncing.

The user expects this full workflow from the short command and should not need to repeat package names.

## Java Verification Contract

When asked to validate a class that has no online judge equivalent:

- Only add or modify test code in its `main` method.
- Do not repair or rewrite the solution logic.
- Run the tests and print clear pass/fail markers.
- Preserve failing cases so Arvind can debug them.
- Do not explain the reason for a failure unless he asks.

## Card Authoring Preferences

- Compressed cards should be minimal and recall-first.
- Expanded cards should contain the meaningful detail.
- Backtracking cards must emphasize the base condition and each state transition, including undo/backtrack behavior.
- Dynamic Programming cards must follow the user's three-stage learning sequence: recursion, memoization, then tabulation. Show each stage's recurrence/transition, base cases, time and space complexity, and recall-level pseudocode. If the Java source omits memoization or tabulation, summarize the missing applicable stage in the card without changing the solution code; clearly label what was implemented versus card-supplied.
- Call out subtle edge cases and implementation nuances.
- Theory cards should be visually distinct from problem cards.
- Related variants need a concise variant lens, such as Combination Sum I vs II or House Robber I vs II.
- Avoid adding generic or unrequested sections such as artificial watch-outs.
- Graph reference cards should link the user's full notes and visual guides instead of compressing them into an inferior summary.
- In tutoring replies, do not provide code snippets until Arvind asks for code.

## Parked Work

- `RemoveDuplicateLetters` is parked. Keep its source in Git, but do not create or update its card until Arvind explicitly resumes it.
- `AtoIRecurse` was once incomplete, but an AtoI card was later requested. Inspect the current source and generated page rather than assuming it is excluded.

## Topic Tracker Workflow

Spreadsheet ID:

`1U4zxsmOFeb92TRb5ZNeLIaN9PTfOM33XNyN4gO0xLTY`

The **Problems Bank** tab is the DesignGurus-driven source of truth. Topic tabs are supplementary collections sourced from TUF Striver and solved NeetCode problems.

Rules:

- TUF source: `https://takeuforward.org/dsa/strivers-a2z-sheet-learn-dsa-a-to-z`
- NeetCode source: `https://neetcode.io/roadmap`
- For NeetCode, inspect the live page with its complete problem list expanded.
- Unless told otherwise, import only problems visibly marked solved/ticked by Arvind.
- Use exact source labels `TUF Striver` and `Neetcode`.
- Detect duplicates against Problems Bank and other imported topic sources.
- Put the exact duplicate match in Notes.
- Duplicate rows use a muted light-red background with normal font color.
- Duplicate supplemental entries are generally marked solved.
- Preserve formulas, validation, filters, conditional formatting, and review-date behavior.
- Filters must include Duplicate Found.
- Trim each tab to its actual last data row; do not leave hundreds of formatted empty rows.

The Dynamic Programming tab was manually created and was given a Greedy-style barebones structure. Verify its live state before making further edits.

## Progress Dashboard

The dashboard is at `revised/progress/index.html` and is served at `http://127.0.0.1:8771/progress/`.

- Daily solved count is based on cards synced.
- History should be displayed newest first.
- After each sync, report the current day's count.

## Graph Reference Material

The handoff bundle includes copies of the main graph notes and visual guide under `references/`.

Original visual:

`/Users/arvindkasale/arvind/work/theory/graphs/out_Graph_Theory_Representation_and_Traversal.png`

The graph theory page should expose these as straightforward links from a simple theory/reference card.

## Git and Safety

- The worktree may contain user changes. Never revert unrelated modifications.
- Do not pull before syncing cards.
- `sync cards` includes authorization to commit the intended sync changes and push the current branch after validation.
- For non-sync work, do not commit or push unless explicitly requested.
- When pushing is requested, inspect status and include only intended changes.
- Generated `.class` files should not be treated as source artifacts.

## Current Direction

Recent work has focused on graphs, including BFS/DFS, cycle detection, topological sorting, shortest paths, grid traversal, and graph theory references. Arvind is beginning a transition toward Dynamic Programming while retaining graphs and backtracking for spaced revision.

## First Actions in a New Chat

1. Read this handoff and both files under `skills/`.
2. Inspect `git status`, the revision package folders, generated HTML pages, and the progress data.
3. Check whether port 8771 is serving the revision root; restart it only if needed.
4. Preserve all parked-work and no-auto-Git rules.
5. Continue from Arvind's newest request rather than redoing old work.
