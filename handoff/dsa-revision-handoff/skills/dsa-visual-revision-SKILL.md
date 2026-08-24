---
name: dsa-visual-revision
description: Generate consistent visual DSA revision HTML pages from solved Java package folders, using recall-card sections, relative source links, LeetCode metadata from the user's tracker when available, and plain-language explanations for fast daily practice.
---

# DSA Visual Revision

Use this skill when the user asks to generate, update, or standardize a DSA visual revision page for a pattern/package of solved problems.

## Goal

Create a GitHub Pages-friendly `index.html` inside the relevant pattern page folder under the problems source set, for example:

```text
revised/problems/warmup/index.html
revised/problems/twopointers/index.html
revised/problems/sliding-window/index.html
```

The output is a browser-native card page, not Markdown. It should help immediate recall before coding. Every pattern page must include a visible `Back to index` link near the top that points back to the repository root with the correct relative path, for example `../../../` from `revised/problems/<pattern>/index.html`.

## Required Card Format

Each problem card must include:

1. Problem class name as title.
2. Relative source link from the HTML file location to the Java file, usually `../com/arvind/revision/<pattern>/ClassName.java` when the page is at `revised/problems/<pattern>/index.html`.
3. A compact metadata line with approach label, difficulty, source link, and LeetCode link.
4. LeetCode difficulty badge when known.
5. LeetCode link when found.
6. Input sample.
7. Output sample.
8. A one-line recall prompt before the detailed sections.
9. `Problem description` section in full card mode only. Keep it plain-language and concrete enough that a non-famous problem name is still understandable.
10. Time complexity, space complexity, and data structures used. Show these in full card mode and in Quick Review mode.
11. `When to recognize it` section.
12. `Visual hook` section with simple inline HTML/CSS cells plus 2-3 step cues for pointer/state movement.
13. `Core move` section.
14. `Code skeleton` section with language-light pseudocode, not a full solution.
15. `Brute force / baseline` section in full card mode only. Explain the simplest obviously-correct approach and why it is less efficient.
16. `Alternate approaches` section in full card mode only. Include 1-2 useful alternatives with clear tradeoffs; avoid filler variations.
17. `Bug magnets` section with 1-3 concise bullets.
18. For classic problem families with common variants, add a `Variant lens` note. This must explain the smallest rule difference from nearby variants, for example unlimited reuse vs use-once, linear vs circular, or duplicates allowed vs duplicates skipped.

Theory cards are different from problem cards. When a card is marked with `difficulty: "Theory"` or its name ends with `Theory`, render it as a lesson card instead of forcing it into the normal problem template. Do not show fake `Problem description`, `Input`, `Output`, `Brute force`, or `Alternate approaches` sections. Use theory-oriented sections such as `Core idea`, `Decision map`, `Use this when`, `Mental picture`, `Complexity snapshot`, `Implementation shape`, `Tradeoffs`, and `Watch outs`. Theory cards should span the full card grid in full-card mode and use a visually distinct style from problem cards.

If the user provides a polished reference document, image, PDF, NotebookLM summary, or workbook extract and asks to preserve or link it, use a simple reference-only theory card instead of reinterpreting the material. Save the reference files beside the pattern `index.html`, link them from the card, and keep the expanded card minimal: a short description plus file links or a preview. Do not add artificial sections such as `Watch outs`, `Tradeoffs`, or generated gotchas unless the user explicitly asks for summarized recall content.

Every page must open in `Quick Review` mode by default. Quick Review compresses cards into rows showing problem, time/space, data structures, prompt, an authored defining move, and top bug magnet. Do not include the full problem description in Quick Review mode. The mode button should initially offer `Card Review`.
Do not show brute-force or alternate-approach sections in Quick Review mode; keep them available only in full or individually expanded cards.

The Quick Review `Defining move` must be written deliberately for each problem. It should capture the smallest distinctive operation needed to reconstruct the approach, usually in one or two short lines. Never derive it by taking the first line of the full code skeleton, and never use generic initialization such as `stack = empty`, `left = 0`, or `answer = 0`.

In full or individually expanded cards, keep this reading order:

1. Recall prompt.
2. Problem description.
3. Input and output sample.
4. Time complexity, space complexity, and data structures.
5. Recognition, visual hook, core move, code skeleton, brute force, alternate approaches, and bug magnets.

If `Variant lens` exists, show it near recognition in full cards and as a compact highlighted line in Quick Review. Keep it short and comparative, not a full explanation.

Keep the problem definition and its concrete example together before moving into solution analysis.

Each Quick Review row must be independently expandable by clicking it or pressing Enter/Space. Expansion should show that problem's full card directly beneath the row without expanding the rest of the list. Buttons and links inside the row/card must keep their own behavior and must not accidentally toggle the row.

Show the total number of problems near the page title. Prefix each card and each Quick Review row with a stable problem number based on the original package/tracker order, for example `#01 MoveZeroes`. Filtering/searching must not renumber the problems.

Order cards by Java source-file creation time so the artifact reflects the sequence in which the user solved the problems. This user now creates and completes new problem files through the same local workflow, so creation time is the default source of truth for newly completed problems.

Persist the sequence immediately in the artifact as a `solvedOrder` list before assigning problem numbers; do not rely on filesystem timestamps during page rendering. On incremental generation:

- Preserve every existing `solvedOrder` entry and number.
- Insert a newly completed file according to its creation time, normally appending it after the previously solved problems.
- Never reorder older cards merely because Git pull, clone, or filesystem operations changed their timestamps.
- If legacy files share the same creation time and their relative solve order is not already persisted, preserve any known existing order. If the user supplies the correct order, treat that correction as authoritative and persist it. Do not guess from alphabetical order.

Each card and Quick Review row must include browser-local revision controls near the problem title:

- `Revised Nx` counter.
- `Last revised: never` or a readable date based on the last increment.
- `+1` button to increment the count and set last revised to today's local date.
- `Reset` button to set count to zero and clear last revised.

Store this state in `localStorage` with stable keys such as `dsa-revision:<pattern>:<ClassName>`. The page must remain usable if browser storage is unavailable.

Add page-level revision controls near the total problem count:

- `+1 All` increments every problem in the pattern page, regardless of active search/filter, and sets each last-revised date to today's browser-local date.
- `Reset All` clears every problem's count and date after a confirmation prompt.

Do not use Mermaid. Do not rely on external image files. Keep the HTML self-contained.

## Generator Workflow

Use the repository generator whenever it exists:

```text
tools/generate-revision-pages.mjs
```

Before every normal `sync cards` run, fetch the latest committed work from GitHub first:

```sh
git pull --rebase
```

Do this before scanning Java files or regenerating pages so Java classes solved from another computer are included. If `git pull --rebase` is blocked by local uncommitted changes, inspect `git status --short`, preserve user work, and either commit the relevant local sync work first or report the blocker clearly. Never discard or reset local changes just to pull.

The generator uses the stacks page as the canonical visual template and preserves each pattern page's authored data blocks: `cards`, `recallDetails`, `definingMoves`, and `solvedOrder`. This prevents new packages from drifting in layout, button styling, Quick Review behavior, sticky navigation, and revision-counter behavior.

For this repository, run it with the bundled Node runtime:

```sh
/Users/arvindkasale/.cache/codex-runtimes/codex-primary-runtime/dependencies/node/bin/node tools/generate-revision-pages.mjs
```

To regenerate only specific patterns, pass their folder names:

```sh
/Users/arvindkasale/.cache/codex-runtimes/codex-primary-runtime/dependencies/node/bin/node tools/generate-revision-pages.mjs stacks hashing
```

When adding a new pattern page, first create/populate that page's authored data blocks, then add the pattern identity to the generator if the default title/subtitle is not good enough. Do not hand-maintain separate HTML templates for each package.

Do not refresh PDFs or upload to Drive during normal `sync cards` work. Keep `sync cards` fast and focused on Java/package scanning, card HTML generation, validation, commit, and push.

When a `sync cards` run adds one or more new problem cards, update the daily solved-count log before committing:

```sh
/Users/arvindkasale/.cache/codex-runtimes/codex-primary-runtime/dependencies/node/bin/node tools/record-daily-solved.mjs --add <new-card-count> --card <pattern>/<ClassName>
```

Use one `--card` argument for each newly synced card. The log lives at:

```text
revised/progress/daily-solved.json
```

If the user asks for the current count, read this file or run:

```sh
/Users/arvindkasale/.cache/codex-runtimes/codex-primary-runtime/dependencies/node/bin/node tools/record-daily-solved.mjs --summary
```

After every `sync cards` response, tell the user the number of newly synced cards, today's solved-card count, and the total solved-card count from the progress log. If no new cards were added, say the count was unchanged. The interactive progress table is at:

```text
revised/progress/index.html
```

Refresh the shared PDFs only when the user explicitly asks for the end-of-day PDF workflow, PDF export, or Drive upload:

```sh
/Users/arvindkasale/.cache/codex-runtimes/codex-primary-runtime/dependencies/node/bin/node tools/export-revision-pdfs.mjs
```

The PDFs live under:

```text
revised/revision-pdfs/
```

Use meaningful names such as `sliding-window-revision.pdf`, `stacks-revision.pdf`, and `fast-slow-pointers-revision.pdf`. The PDF exporter renders pages in expanded card mode. Treat PDF generation as a separate end-of-day artifact workflow, not part of the normal card sync loop.

After regenerating PDFs in that explicit end-of-day workflow, update the matching Google Drive copies through the Google Drive connector. The shared Drive target is recorded in:

```text
revised/revision-pdfs/drive-manifest.json
```

Drive folder:

```text
DSA Revision PDFs
https://drive.google.com/drive/folders/1ociiJd026Ra4sRsEIHNMl5_rfN9wpuWD
```

Use the file IDs in `drive-manifest.json` with the Drive `update_file` action so existing Drive PDFs are replaced in place. Do not upload duplicate PDFs unless a new pattern has no Drive file yet; for a new pattern, upload it to the same folder and add the new file ID to the manifest before committing.

## Language Style

Use easy recall language:

- Prefer `When one string only needs to appear in order inside another string` over abstract terms like `subsequence condition`.
- Prefer mental visuals: `drop pins`, `seen bucket`, `vote cancellation`, `write slot`, `26 boxes`.
- Use `When to recognize it` instead of `Trigger`.
- Use `Bug magnets` instead of `Gotchas`.
- Add a short `Problem description` for every card, especially when the class/problem name is not self-explanatory.
- When an authoritative problem page is known, use its statement as the factual source, then paraphrase it into plain language. A strong description states the input, exact required output, and important constraints or preservation rules without explaining the solution.
- Add Big-O time, Big-O space, and the practical data structures used. Keep this short: `O(n)`, `O(1)`, `HashSet`, `write pointer`, `int[26]`.
- Include code skeletons that show shape, not full implementation detail.
- Keep full-card `Code skeleton` and Quick Review `Defining move` separate: the skeleton shows the overall flow, while the defining move is the algorithm's most memorable decision or state transition.
- Explain brute force as a useful correctness baseline, then name its cost. Alternate approaches should teach meaningful tradeoffs.
- Make explanations direct enough to read in 10-20 seconds.
- For backtracking-style problems, emphasize the exact base condition and state transitions. The `Core move`, `Code skeleton`, and `Defining move` should make these parts obvious:
  - `Base condition`: when to save/add/return.
  - `State carried`: for example `idx`, `path`, `open`, `closed`, `last char`, `remaining`, `visited`.
  - `Allowed transitions`: choices that can recurse from this state.
  - `Blocked transitions`: choices rejected by the current state and why.
  - `Undo step`: what must be reverted after recursion, such as deleting the last path character or clearing `visited[i]`.
- For family variants such as `Combination Sum I/II/III`, `House Robber I/II/III`, `Subsets/Subsets II`, or `Permutations/Permutations II`, include a `Variant lens` that names the variant and the rule that changes the state transition or duplicate handling.

## Metadata Workflow

When the user's tracker spreadsheet is available, use it as the source of truth for:

- Problem name
- LeetCode link
- Pattern
- Approach Notes
- Gotchas / Key Insight

For difficulty, prioritize the known LeetCode difficulty over the tracker when there is a confident LeetCode problem match. If the tracker difficulty differs from LeetCode, use the LeetCode difficulty in the card and explicitly mention the delta to the user in the sync summary. If there is no confident LeetCode match, use the tracker difficulty when available; otherwise classify custom/local-only practice problems conservatively and say that it is a local classification.

For this user's current tracker, the known spreadsheet is:

```text
https://docs.google.com/spreadsheets/d/1U4zxsmOFeb92TRb5ZNeLIaN9PTfOM33XNyN4gO0xLTY/edit
```

Prefer the `🧩 Problems Bank` tab. Read a bounded range and match by problem name/class-name variants.

If the tracker does not have a link, use known LeetCode slugs only when confident. Otherwise omit the LeetCode link instead of guessing.

## Visual Design

Use a clean card layout:

- 2-column card grid on desktop, 1-column on mobile.
- Each card has a clean header, compact metadata line, recall prompt, problem description, sample input/output, complexity strip, and recall sections in that order.
- The header shows the total problem count; every card title starts with a stable problem number.
- Time, space, and data structures should be visually scannable in full cards and still visible in Quick Review mode.
- In Quick Review, do not render approach, complexity, and data structures as three undifferentiated text lines. Give the approach its own subtle treatment, show Time and Space as compact labeled facts, and put data structures on a separate readable `Uses` line.
- Revision count, last revised date, `+1`, and `Reset` controls should sit near the problem title in both full cards and Quick Review mode.
- Page-level `+1 All` and guarded `Reset All` controls should sit near the total problem count.
- Keep the `Back to index` link and page header sticky while scrolling so navigation, title, search, mode switch, and page-level controls remain available. Stack them without overlap.
- Quick Review rows should visually indicate that they can expand, and only the selected rows should reveal full cards.
- Make full-card and Quick Review row borders reflect difficulty: green for Easy, gold for Medium, and red for Hard. Show the difficulty badge directly beside the problem name in Quick Review mode.
- Use a restrained multi-color study palette: neutral paper/panels, green for recall/actions, blue for explanations, gold for complexity accents, and coral/red for bug magnets. Do not let one hue dominate the entire page.
- Use colored edge accents, clear hover/focus feedback, and subtle shadows to improve hierarchy without adding decorative clutter.
- Use small inline visual cells for arrays/strings plus step cues for pointer/state movement.
- Include a `Quick Review` button near search.
- Avoid decorative clutter; this is a study tool.
- Keep cards at 8px radius or less.

## Repository Linking

Update the repo README with a package-level link:

```md
- [Warmup](revised/problems/warmup/)
- [Two Pointers](revised/problems/twopointers/)
```

Use folder links where `index.html` exists so GitHub Pages renders clean URLs.

## Validation

After editing:

1. Run a syntax check against inline scripts by extracting `<script>` contents and passing them to `new Function(...)` in Node.
2. If a local server is already running, verify the page returns HTTP 200.
3. Check that source links are relative and do not contain absolute local paths.
4. Browser-check every regenerated page in Quick Review mode: rows render by default, a row expands on click, Enter/Space toggles expansion, `Card Review` switches to full cards, and the browser console has no errors.
5. Check `git status` and avoid committing `.DS_Store`.
