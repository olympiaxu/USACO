``` java
// 1D overlap
int overlap = Math.max(0, Math.min(R1, R2) - Math.max(L1, L2));

// Area of a rectangle
int area = (ax2 - ax1) * (ay2 - ay1)

//for checking coords, find if specific spot sits inside
private static boolean isInside(int px, int py, int x1, int y1, int x2, int y2) {
    return (x1 <= px && px <= x2) && (y1 <= py && py <= y2);
}```

Remaining/Visible Area = Total Area - Overlap Area

