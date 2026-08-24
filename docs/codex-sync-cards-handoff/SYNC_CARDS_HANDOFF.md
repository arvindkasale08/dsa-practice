# DSA Revision Cards Sync Handoff

This document is the setup and operating template for running Arvind's `sync cards` workflow from another computer that has Codex.

## What This Workflow Does

When Arvind says `sync cards`, Codex should:

1. Scan all solved Java classes under `revised/problems/com/arvind/revision/<pattern>/`.
2. Generate or update the matching visual revision pages under `revised/problems/<pattern>/index.html`.
3. Keep the generated pages consistent across patterns: quick-review mode, expandable rows, sticky header, difficulty borders, local revision counters, and authored recall sections.
4. Record the number of newly synced cards in `revised/progress/daily-solved.json`.
5. Regenerate `revised/progress/index.html`.
6. Validate all generated HTML scripts.
7. Commit and push only the relevant sync files.
8. Skip PDF export and Drive upload unless Arvind explicitly asks for the end-of-day PDF workflow.

## Required Local Repo

Clone the same repo:

```sh
git clone git@github.com:arvindkasale08/dsa-practice.git
cd dsa-practice
```

Expected structure:

```text
revised/problems/com/arvind/revision/
revised/problems/<pattern>/index.html
revised/progress/daily-solved.json
revised/progress/index.html
tools/generate-revision-pages.mjs
tools/record-daily-solved.mjs
tools/export-revision-pdfs.mjs
```

The repo-side scripts are the source of truth. The Codex skill is the operating guide.

## Files Included In This Handoff Kit

```text
SYNC_CARDS_HANDOFF.md
dsa-visual-revision.SKILL.md
generate-revision-pages.mjs
record-daily-solved.mjs
export-revision-pdfs.mjs
```

On another machine, the scripts should normally come from the repo. The copies in this kit are a fallback/reference.

## Install The Skill On Another Computer

Create this folder if needed:

```sh
mkdir -p ~/.codex/skills/dsa-visual-revision
```

Copy `dsa-visual-revision.SKILL.md` into:

```text
~/.codex/skills/dsa-visual-revision/SKILL.md
```

Then start a new Codex task from inside the repo and say:

```text
Use the dsa-visual-revision skill. When I say "sync cards", scan the whole revised/problems Java source tree, regenerate revision pages, update progress, validate, commit, and push. Skip PDFs unless I explicitly ask for end-of-day PDF export.
```

## Node Runtime

On Arvind's main machine the command uses Codex's bundled Node:

```sh
/Users/arvindkasale/.cache/codex-runtimes/codex-primary-runtime/dependencies/node/bin/node tools/generate-revision-pages.mjs
```

On another computer, prefer global Node if available:

```sh
node tools/generate-revision-pages.mjs
node tools/record-daily-solved.mjs --summary
```

If global Node is missing, ask Codex on that machine to locate its bundled Node runtime and substitute that path.

## Standard Sync Commands

Regenerate all pages:

```sh
node tools/generate-revision-pages.mjs
```

Regenerate specific patterns:

```sh
node tools/generate-revision-pages.mjs greedy graphs backtracking
```

Record newly synced cards:

```sh
node tools/record-daily-solved.mjs --add 1 --card greedy/ValidPalindromeII
```

Show current progress:

```sh
node tools/record-daily-solved.mjs --summary
```

Validate generated page scripts:

```sh
node -e 'const fs=require("fs"); const files=fs.readdirSync("revised/problems",{withFileTypes:true}).filter(d=>d.isDirectory()).map(d=>`revised/problems/${d.name}/index.html`).filter(fs.existsSync); for (const f of files) { const html=fs.readFileSync(f,"utf8"); for (const m of html.matchAll(/<script>([\s\S]*?)<\/script>/g)) new Function(m[1]); } console.log(`validated ${files.length} problem pages`);'
```

Check no absolute local links leaked into generated pages:

```sh
rg -n 'href="/Users|src="/Users|/Users/arvindkasale' revised/problems revised/progress
```

Start local server:

```sh
python3 -m http.server 8771 --directory revised
```

Cards home:

```text
http://127.0.0.1:8771/problems/
```

Progress dashboard:

```text
http://127.0.0.1:8771/progress/
```

## Git Rules

Before syncing:

```sh
git pull --rebase
git status --short
```

Stage only relevant files:

```text
revised/problems/com/arvind/revision/<pattern>/<ClassName>.java
revised/problems/<pattern>/index.html
revised/progress/daily-solved.json
revised/progress/index.html
tools/generate-revision-pages.mjs
README.md only if index links changed
```

Do not stage unrelated local files such as:

```text
.idea/
.agents/
.chrome-profile/
tools/do_sync.py
tools/python_lib/
tools/sync-neetcode-backtracking.mjs
tools/test_tabs.py
```

Commit message style:

```text
Sync <topic/problem> revision card
Sync greedy revision cards
```

Then push:

```sh
git push
```

## Card Quality Rules

Every card should be useful for immediate recall. Avoid generic placeholder text. Prefer:

- `When to recognize it`
- `Visual hook`
- `Core move`
- `Code skeleton`
- `Brute force / baseline`
- `Alternate approaches`
- `Bug magnets`
- `Variant lens` for family problems

For backtracking, emphasize:

- base condition
- state carried
- allowed transitions
- blocked transitions
- undo step

For greedy, emphasize:

- what local choice is being locked
- why that local choice is safe
- the ordering that makes the choice obvious
- the proof idea, if relevant

For variants such as `Combination Sum I/II/III`, `Subsets/Subsets II`, `House Robber I/II/III`, always include how the variant differs.

## Progress Rule

Only count newly synced problem cards. Do not count generic theory cards unless Arvind explicitly says to count them.

After every sync response, report:

```text
New card synced: <n>
Today's count: <today>
Total synced cards: <total>
Commit: <hash> - <message>
```

## PDF Rule

Do not generate PDFs during normal `sync cards`.

Only run PDF export when Arvind explicitly asks for end-of-day PDF export or Drive upload:

```sh
node tools/export-revision-pdfs.mjs
```

The PDFs live under:

```text
revised/revision-pdfs/
```

## Useful Prompt For The Other Codex

Paste this into a new Codex task on the other computer:

```text
I am working in the dsa-practice repo. Please use the dsa-visual-revision workflow from the attached handoff. When I say "sync cards", scan all Java files under revised/problems/com/arvind/revision, update the visual revision HTML pages, update the progress dashboard, validate generated pages, commit, and push. Do not generate PDFs or upload to Drive unless I explicitly ask.
```
