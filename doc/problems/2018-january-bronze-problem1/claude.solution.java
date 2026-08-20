import java.io.*;
import java.util.*;

public class billboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("billboard.in"));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ax1 = Integer.parseInt(st.nextToken());
        int ay1 = Integer.parseInt(st.nextToken());
        int ax2 = Integer.parseInt(st.nextToken());
        int ay2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int bx1 = Integer.parseInt(st.nextToken());
        int by1 = Integer.parseInt(st.nextToken());
        int bx2 = Integer.parseInt(st.nextToken());
        int by2 = Integer.parseInt(st.nextToken());

        br.close();

        // Clip the cow feed billboard to the lawnmower billboard.
        // This is the actual overlapping region.
        int ox1 = Math.max(ax1, bx1);
        int oy1 = Math.max(ay1, by1);
        int ox2 = Math.min(ax2, bx2);
        int oy2 = Math.min(ay2, by2);

        // If there is no real overlap, the tarp is the whole billboard.
        if (ox1 >= ox2 || oy1 >= oy2) {
            System.out.println((long)(ax2 - ax1) * (ay2 - ay1));
            return;
        }

        // The overlap spans the full width -> it can shave a horizontal strip.
        if (ox1 == ax1 && ox2 == ax2) {
            if (oy1 == ay1) ay1 = oy2;   // strip removed from the bottom
            if (oy2 == ay2) ay2 = oy1;   // strip removed from the top
        }

        // The overlap spans the full height -> it can shave a vertical strip.
        if (oy1 == ay1 && oy2 == ay2) {
            if (ox1 == ax1) ax1 = ox2;   // strip removed from the left
            if (ox2 == ax2) ax2 = ox1;   // strip removed from the right
        }

        long width  = Math.max(0, ax2 - ax1);
        long height = Math.max(0, ay2 - ay1);

        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
        pw.println(width * height);
        pw.close();
    }
}