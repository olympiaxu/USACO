**RECTANGLE GEOMETRY** 
problems involving rectangles whose sides are parallel to the coordinate axes.

**`Contain`**
A rectangle is stored as two opposite corners: 
`(x1, y1)` bottom-left  
`(x2, y2)` top-right

`x1 ≤ x2` and `y1 ≤ y2`.

```
width  = x2 - x1
height = y2 - y1
area   = (x2 - x1) * (y2 - y1)
```

Never assume the input gives the corners in this order. If a problem doesn't specify which two corners, normalize:

```java
int lx = Math.min(x1, x2), hx = Math.max(x1, x2);
int ly = Math.min(y1, y2), hy = Math.max(y1, y2);
```

**`Separability`**
Two axis-aligned rectangles overlap if and only if they overlap on the x-axis *and* on the y-axis. The axes never affect each other.

1. Solve the problem in 1D.
2. Run it on `x`.
3. Run it on `y`.
4. Combine two answers.


**Rotation: If a rectangle is tilted, its x-extent depends on its y-position, and the axes stop being independent, and none of the formulas below apply.**

**`Intersection Formula`**
Segments `[l1, r1]` and `[l2, r2]` overlap by:

```java
int overlap = Math.max(0, Math.min(r1, r2) - Math.max(l1, l2));
```

Overlap starts at the *rightmost left edge* and ends at the *leftmost right edge*.

`[2,7]` and `[5,9]` → starts at 5, ends at 7 → 2.
`[2,4]` and `[6,9]` → starts at 6, ends at 4 → −2 → clamped to 0.

For 2D, apply it to each axis and multiply:

```java
int w = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
int h = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
int intersectionArea = w * h;
```

**`Overlap and Containment`**
When the problem wants a yes or no, test directly instead of computing an area and comparing it to zero.

1. Do A and B overlap with positive area?

```java
ax1 < bx2 && bx1 < ax2 && ay1 < by2 && by1 < ay2
```

2. Do A and B overlap *or touch*?

Same test except `<=` replaces `<`.

3. Is A entirely inside B?

```java
bx1 <= ax1 && ax2 <= bx2 && by1 <= ay1 && ay2 <= by2
```

4. Is point `(px, py)` inside A?

```java
ax1 <= px && px <= ax2 && ay1 <= py && py <= ay2
```

**`Union and Inclusion-Exclusion`**
Adding two areas counts the shared region twice, so subtract it back.

```
|A ∪ B| = |A| + |B| - |A ∩ B|
```

For three, the signs alternate:

```
|A ∪ B ∪ C| = |A| + |B| + |C|
            - |A∩B| - |A∩C| - |B∩C|
            + |A∩B∩C|
```

Fine for 2 or 3, not for past ~20 though.

**`Complementary Counting`**

```
visible area = total area - blocked area
```

Use if *what is left* is harder to describe than *what was taken away*. Like an L, ring, hole, etc., just subtract.

**`Corners vs Cells`**

1. Corner coordinates — number names a grid *line*

Width is `x2 - x1`. `x1 = 2, x2 = 5` → width 3.
"corners at (2,3) and (5,7)"

2. Cell indices — number names a unit *square*

Width is `x2 - x1 + 1`. `x1 = 2, x2 = 5` → width 4.
"rows 2 through 5"


Decide which convention the problem uses before.