# DSA Tracker Workflow

Use this Google Sheet as the main tracker:
- **Sheet Name**: 📅 Arvind Prep Daily Tracker [Final]
- **URL**: https://docs.google.com/spreadsheets/d/1U4zxsmOFeb92TRb5ZNeLIaN9PTfOM33XNyN4gO0xLTY/edit?gid=1723456789#gid=1723456789

## Core Idea
🧩 Problems Bank is the main source of truth. It is primarily driven by DesignGurus/Grokking content. Any DesignGurus problem status, dates, review data, confidence, notes, attempts, etc. should ultimately live in 🧩 Problems Bank.

## Helper/Topic Tabs
Topic tabs are helper tabs, not the main tracker. Examples: 🔙 Backtracking, 📈 Graphs, future DP, Trees, etc.

Use topic tabs for:
- Striver/TUF topic lists
- NeetCode topic lists
- Extra problems not already cleanly represented in the main bank
- Duplicate analysis against 🧩 Problems Bank
- Topic-specific planning

Avoid duplicating DesignGurus rows in topic tabs if those rows already exist in 🧩 Problems Bank.

### Copying/Deleting Matching DesignGurus Rows
When a DesignGurus problem appears in a topic tab:
1. Copy its solved/review metadata back into the matching 🧩 Problems Bank row.
2. Match by Problem ID first, then LeetCode URL/problem name if needed.
3. After confirming the main bank is updated, delete that DesignGurus row from the topic tab.

### Topic Tab Styling and Hygiene
- Keep only relevant external-source rows, such as TUF/Striver or NeetCode.
- Add a `Source` column where applicable.
- Mark duplicates against the main bank and other imported sources.
- Use muted/light red background for duplicate rows.
- Do not change duplicate link font color.
- Keep filters active through the duplicate column if present.
- Trim the sheet so it stops at the last real row, no 1000-row junk.

### Future Topic Imports
For future topic imports:
1. Ask what source to use: Striver, NeetCode, Problems Bank, or another list.
2. Ask whether to import solved, unsolved, or all visible problems.
3. Add source-specific rows to the topic tab.
4. Cross-check duplicates against 🧩 Problems Bank.
5. Preserve/repair review formulas and filters.
6. Verify no `#REF!` or blank formula breakage.

### Current Policy
- 🧩 Problems Bank = DesignGurus main bank.
- Topic tabs = supplemental source tabs.
- Do not let the same DesignGurus problem live permanently in both places.
