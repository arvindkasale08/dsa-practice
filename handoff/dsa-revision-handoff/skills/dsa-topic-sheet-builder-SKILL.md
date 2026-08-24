---
name: dsa-topic-sheet-builder
description: Build and maintain Arvind's DSA tracker topic tabs in Google Sheets. Use when Codex is asked to create a new topic tab such as Graphs, DP, Trees, Heaps, Greedy, or Backtracking; import problems from sources such as TUF Striver, NeetCode, or the main Problems Bank; mark duplicate problems; fix topic-tab formulas, filters, formatting, or table ranges; or keep newly added topic sheets structurally consistent with the existing tracker.
---

# DSA Topic Sheet Builder

## Purpose

Use this skill to create clean, consistent topic-specific tabs in Arvind's prep tracker. The tab should behave like a focused problem list, not a noisy dump: clear headers, working review columns, source tracking, duplicate flags, restrained duplicate styling, and a table/filter range that stops at the last real row.

Always combine this with the `google-drive:google-sheets` skill for live Google Sheets reads and writes.

## Guided Intake

Run this as a step-by-step workflow. Do not silently guess source scope when it materially affects what rows get created.

Before importing problems, establish these details:

1. Target topic and tab name, for example `Graphs`, `DP`, `Trees`, or `Greedy`.
2. Whether the user wants:
   - structure only,
   - import from the main `🧩 Problems Bank`,
   - import from a source such as TUF Striver,
   - import from NeetCode,
   - or combine multiple sources.
3. Source links or source locations:
   - TUF/Striver page URL or section name.
   - NeetCode roadmap/practice URL and whether to use solved, unsolved, or all visible problems.
   - Any other course/page/sheet link.
4. Initial status for imported rows, usually `Not Started` unless the user says they already solved them.
5. Duplicate behavior:
   - mark duplicates only,
   - include duplicates but annotate them,
   - or skip duplicates entirely.

Ask the user for missing source information when it is not already in the current conversation. Keep the prompt short and concrete, for example:

`Which source should I use for this topic: Problems Bank only, TUF link, NeetCode link, or another list?`

Proceed without asking only when the user has already provided enough context, such as a spreadsheet URL plus an explicit source and topic.

## Core Workflow

1. Identify the target spreadsheet and exact topic tab.
   - Default tracker: `📅 Arvind Prep Daily Tracker [Final]`.
   - Prefer the user-provided spreadsheet URL or ID.
   - Read spreadsheet metadata before editing.

2. Complete the guided intake.
   - Prompt for missing source links or source scope.
   - If the user says “just create structure,” stop before importing rows.
   - If the user says “same as Graphs/Backtracking,” use this skill’s schema and formatting rules.

3. If creating a new tab, mirror the tracker topic-tab structure.
   - Use the schema in [references/topic-tab-schema.md](references/topic-tab-schema.md).
   - Add or preserve frozen header row and frozen first four columns.
   - Keep the row count close to actual data after import.

4. Import only the requested source data.
   - If the user says “structure only,” do not populate problems.
   - If importing TUF, NeetCode, or another source, set `Source` per row.
   - Do not invent LeetCode links. Search/verify links when asked; mark unavailable links as `not found`.
   - If the user says mark items unsolved, set `Status` to `Not Started`.
   - For NeetCode imports, use the live NeetCode page/roadmap whenever browser access is available. Expand the requested topic section and extract from the full problem list, not only the initially visible or collapsed rows. Verify the extracted count against the page count, for example `Backtracking (19 / 36)`, before writing to the sheet.
   - When the user asks for solved NeetCode problems, import the checked/completed rows from the expanded list. If the user says they want to solve them again, still import those checked rows but set `Status` to `Not Started`.

5. Mark duplicates explicitly.
   - Use `Duplicate Found` as a static `Yes`/`No` value after computing duplicates.
   - In `Notes`, explain the exact duplicate source when useful, for example `Duplicate of Problems Bank: Number of Islands` or `Duplicate of TUF-G009 Rotten Oranges`.
   - Do not use a long spilling `ARRAYFORMULA` for duplicates once mixed source blocks exist; it can break when later rows are manually populated.

6. Format duplicates gently.
   - Duplicate rows should use only a light red background.
   - Do not change link font color, text color, or boldness for duplicate rows.
   - Avoid loud purple, bright red text, or whole-sheet heavy coloring.

7. Configure table behavior.
   - Apply a basic filter over the actual populated table range.
   - Include `Duplicate Found` in the filter range.
   - Stop the table/filter at the last populated problem row.
   - Delete or avoid formatting empty rows below the final row.

8. Verify after every edit.
   - Read back headers and representative rows.
   - Check for `#REF!`, broken spill formulas, missing source values, and missing filter coverage.
   - Confirm the tab visually stops at the last real row when the user asks for cleanup.

## Duplicate Calculation

Compute duplicates against all relevant existing sources:

- Main bank duplicate: problem name matches an existing `🧩 Problems Bank` problem name after normalization, or the LeetCode URL matches an existing LeetCode URL.
- Same-topic duplicate: newly imported source row matches an already present row in the same topic tab by normalized problem name or LeetCode URL.
- Cross-source duplicate: NeetCode/TUF/etc. row matches another imported source row in the topic tab.

Normalize names before comparing:

- Lowercase.
- Trim whitespace.
- Remove punctuation and extra spaces.
- Treat small title variants as equivalent when obvious, e.g. `Rotting Oranges` and `Rotten Oranges`.
- Prefer LeetCode URL equality when URLs exist.

## Output Expectations

When finished, report:

- Which sheet and tab were updated.
- What ranges or columns were changed.
- Whether formulas/filter/duplicate styling were verified.
- Any unresolved link or duplicate ambiguity.

Keep the response short unless the user asks for details.
