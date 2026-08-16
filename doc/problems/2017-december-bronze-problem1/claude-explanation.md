"
# Blocked Billboard — Problem Explanation

**USACO 2017 December Contest, Bronze — Problem 1**

---

## The Story

Bessie looks out her barn window at two rectangular billboards. A rectangular truck parks between her and the billboards, potentially covering part (or all) of what she can see.

Your job: figure out **how much billboard area Bessie can still see**.

---

## What You're Given

Three rectangles, each described on its own line by four integers:

```
x1 y1 x2 y2
```

- `(x1, y1)` — the **lower-left** corner
- `(x2, y2)` — the **upper-right** corner

| Line | Rectangle |
|------|-----------|
| 1 | First billboard |
| 2 | Second billboard |
| 3 | Truck |

All rectangles are **axis-aligned** (their sides run parallel to the x- and y-axes — nothing is rotated or tilted).

---

## What You Must Output

A single integer: the **total combined visible area** of both billboards after the truck covers whatever it covers.

"Visible area" means the part of a billboard that the truck is *not* sitting on top of.

---

## Constraints & Guarantees

- All coordinates are integers in the range **-1000 to +1000** (negatives are allowed — the origin is not necessarily at a corner of your field of view).
- **The two billboards never overlap each other** by any positive area. This is a guarantee from the problem, not something you need to verify or handle.
- Nothing is guaranteed about the truck. It may overlap **neither**, **one**, or **both** billboards, and its overlap may be partial or total.

---

## Understanding the Sample

```
1 2 3 5     ← Billboard A
6 0 10 4    ← Billboard B
2 1 8 3     ← Truck
```

**Billboard A** spans x from 1 to 3 and y from 2 to 5, so it is 2 wide and 3 tall → total area **6**.

**Billboard B** spans x from 6 to 10 and y from 0 to 4, so it is 4 wide and 4 tall → total area **16**.

**The truck** spans x from 2 to 8 and y from 1 to 3 — a wide, short rectangle lying across the bottom-right of A and the lower-left of B.

The truck clips a **1 × 1** corner off Billboard A, leaving **5** visible.
The truck clips a **2 × 2** corner off Billboard B, leaving **12** visible.

Total: `5 + 12 = 17` — matching the expected output.

---

## Things Worth Thinking Carefully About

These are the situations that separate a correct solution from a nearly-correct one:

1. **Partial overlap is the normal case.** The truck rarely lines up neatly with a billboard. It may cover a corner, a strip through the middle, or a whole edge.

2. **The truck might miss entirely.** If the truck is completely off to the side, above, or below a billboard, that billboard's full area counts.

3. **Touching is not covering.** If the truck's right edge sits exactly on a billboard's left edge, they share a line but no *area*. Nothing is blocked. Any overlap of zero or negative width/height contributes nothing.

4. **The truck may swallow a billboard whole.** Then that billboard contributes 0 to the answer, not a negative number.

5. **One truck, two billboards.** The truck interacts with each billboard independently — but since the billboards themselves never overlap, you never risk counting the same square unit twice.

6. **Negative coordinates.** If you plan to model the field of view as a grid, remember that x and y can go down to -1000. Array indices can't be negative, so you'd need to shift coordinates.

---

## Practical Notes

- This is a **2017** contest problem, so it uses **file I/O**: read from `billboard.in`, write to `billboard.out`. (Newer USACO contests use standard input/output, but this one does not.)
- The largest possible answer is well within the range of a normal 32-bit integer — the entire visible plane is only 2000 × 2000.
- The output is a single integer with no extra text, units, or formatting.

---

## The Question in One Sentence

> Given two non-overlapping axis-aligned rectangles and a third rectangle that may sit on top of them, what is the combined area of the first two that the third does not cover?
"