import java.io.*;
import java.util.*;

public class BlockedBillboardII{

private static boolean isInside(int px, int py, int x1, int y1, int x2, int y2) {
    return (x1 <= px && px <= x2) && (y1 <= py && py <= y2);
}

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("billboard.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("billboard.out"));

        // A = lawnmower billboard, B = cow feed billboard
        int ax1 = sc.nextInt(), ay1 = sc.nextInt();
        int ax2 = sc.nextInt(), ay2 = sc.nextInt();
        int bx1 = sc.nextInt(), by1 = sc.nextInt();
        int bx2 = sc.nextInt(), by2 = sc.nextInt();

        int Aarea = (ax2 - ax1) * (ay2 - ay1);

        // checks if points r in rectangle, which is billboard B
        int cornersCovered = 0;
        if (isInside(ax1, ay1, bx1, by1, bx2, by2)) cornersCovered++;
        if (isInside(ax2, ay1, bx1, by1, bx2, by2)) cornersCovered++;
        if (isInside(ax1, ay2, bx1, by1, bx2, by2)) cornersCovered++;
        if (isInside(ax2, ay2, bx1, by1, bx2, by2)) cornersCovered++;

        int overlapW = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int overlapH = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        int overlapArea = overlapW * overlapH;

        if (cornersCovered == 4){
            pw.print(0);
        }
        else if (cornersCovered == 2){
            pw.print(Aarea - overlapArea);
        }
        else{
            pw.print(Aarea);
        }
        pw.close();
        sc.close();
    }
} 