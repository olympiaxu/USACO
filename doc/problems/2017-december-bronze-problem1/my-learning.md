**Intersection formula**
`overlap_width  = max(0, min(right edges)  - max(left edges))`
`overlap_height = max(0, min(top edges)    - max(bottom edges))`
in my code I used 'l' instead of 'h'
`overlap_area   = width × height`

**More**
`sc.close()` -- forgot to call, not necessary but good to build the habit. 

Learned what `BufferedReader` + `StringTokenizer` are and how to use. Faster than `Scanner`.

**MY code vs. CLAUDE's code**
"
You wrote the intersection formula twice, with `b1`/`b2` prefixes and `x1`–`x6` names. It works here because there are exactly two billboards. But notice what happens if the problem said "N billboards" — my version changes one loop bound, yours needs a rewrite.

The lesson isn't "always write helper methods." It's this: **when you catch yourself copy-pasting a block and editing the variable numbers, that's a signal.** Sometimes the right response is to ignore it (contest speed matters, and duplicating twice is fine). But you should *notice* it, because copy-paste-and-edit is where the majority of contest bugs are born. The most common way to fail this problem is pasting the b1 overlap block, changing `x1→x3` and `x2→x4`, and forgetting one of the four substitutions. Your code has eight such edits and you got all eight right — but that was care, not structure.

Same with `x1` through `x6`. It's fine at six variables. At twelve you'll mix them up. Names like `truckX1` cost nothing to type and eliminate a whole bug class.
"