import java.io.*;
import java.util.*;

public class billboard {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

        int[][] r = new int[3][4];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 4; j++) {
                r[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        in.close();

        int total = 0;
        for (int i = 0; i < 2; i++) {
            total += area(r[i]) - overlap(r[i], r[2]);
        }

        out.println(total);
        out.close();
    }

    /** Area of an axis-aligned rectangle given as {x1, y1, x2, y2}. */
    static int area(int[] a) {
        return (a[2] - a[0]) * (a[3] - a[1]);
    }

    /** Area shared by two axis-aligned rectangles; 0 if they don't overlap. */
    static int overlap(int[] a, int[] b) {
        int w = Math.min(a[2], b[2]) - Math.max(a[0], b[0]);
        int h = Math.min(a[3], b[3]) - Math.max(a[1], b[1]);
        if (w <= 0 || h <= 0) return 0;
        return w * h;
    }
}