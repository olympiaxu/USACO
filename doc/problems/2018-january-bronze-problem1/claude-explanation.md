"
# Blocked Billboard II — Problem Explanation

**Source:** USACO 2018 January Contest, Bronze — Problem 1

---

## The Setup

There are two axis-aligned rectangles in a 2D plane:

1. **The lawnmower billboard** — the one Bessie wants gone from her view.
2. **The cow feed billboard** — sits *in front of* the lawnmower billboard and may cover part of it.

Bessie wants to cover every remaining visible piece of the lawnmower billboard with a single rectangular tarp. The tarp must be axis-aligned (no tilting).

**Goal:** output the **minimum area** of that tarp.

---

## Input Format

File: `billboard.in`

| Line | Contents | Meaning |
|------|----------|---------|
| 1 | `x1 y1 x2 y2` | Lower-left and upper-right corners of the **lawnmower** billboard |
| 2 | `x1 y1 x2 y2` | Lower-left and upper-right corners of the **cow feed** billboard |

All coordinates are integers in the range `-1000` to `+1000`.

Note that the input gives **corner coordinates**, not cell indices. A rectangle from `x1` to `x2` has width `x2 - x1`.

---

## Output Format

File: `billboard.out`

A single integer: the minimum tarp area.

---

## Sample

**Input:**
```
2 1 7 4
5 -1 10 3
```

**Output:**
```
15
```

**Why 15?** The lawnmower billboard spans `x` from 2 to 7 and `y` from 1 to 4, so its full area is `5 × 3 = 15`. The cow feed billboard covers its lower-right corner — but only *part* of that corner. Since a corner bite doesn't reduce the bounding rectangle of what's still exposed, the tarp still has to be the full `5 × 3` billboard.

---

## The Key Insight (Conceptually)

**The tarp is a rectangle, not a shape that hugs the exposed region.** This is the whole problem. The exposed portion of the lawnmower billboard could be L-shaped, U-shaped, or a rectangle-with-a-hole — but the tarp must be a rectangle that contains *all* of it. So what you actually need is the **bounding box of the uncovered region**, not the uncovered area itself.

**Partial coverage almost never helps.** If the cow feed billboard only bites off a corner or pokes a hole in the middle, the leftmost/rightmost/topmost/bottommost exposed points of the lawnmower billboard are unchanged, so the bounding box is still the entire lawnmower billboard.

**Coverage only helps when it's a full "slab."** The tarp shrinks only when the cow feed billboard spans the *entire* width or the *entire* height of the lawnmower billboard, and shaves off a strip from one edge. For example, if the cow feed billboard covers the full horizontal extent of the lawnmower billboard and everything above `y = 3`, then the exposed region's top edge drops to `y = 3` and the tarp can be shorter.

**Full coverage means area 0.** If the cow feed billboard contains the entire lawnmower billboard, nothing is exposed and no tarp is needed.

---

## Cases to Reason About

1. **No overlap at all** → tarp = full lawnmower billboard.
2. **Partial overlap that doesn't span a full dimension** (corner bite, edge bite that doesn't reach across, interior hole) → tarp = full lawnmower billboard.
3. **Overlap spanning the full width**, cutting off a horizontal strip from the top or bottom → height shrinks.
4. **Overlap spanning the full height**, cutting off a vertical strip from the left or right → width shrinks.
5. **Complete containment** → area 0.

---

## Constraints & Complexity Note

Coordinates are bounded by `±1000`, so the coordinate space is at most `2001 × 2001` ≈ 4 million points. That's small enough that a brute-force grid approach is viable, but the geometry-only approach is `O(1)` and avoids any indexing/offset headaches from negative coordinates.

---

## Terminology Reminder

- **Bounding box** — the smallest axis-aligned rectangle containing a given set of points.
- **Axis-aligned** — sides parallel to the `x` and `y` axes; no rotation.
- **Spanning a dimension** — one rectangle's extent in `x` (or `y`) fully contains the other's extent in that same axis.
"