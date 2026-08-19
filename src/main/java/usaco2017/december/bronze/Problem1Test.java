
import java.io.*;
import java.util.*;

public class BlockedBillboard {
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(new File("billboard.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("billboard.out"));

        //b1
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        //b2
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        int x4 = sc.nextInt();
        int y4 = sc.nextInt();

        //truck
        int x5 = sc.nextInt();
        int y5 = sc.nextInt();
        int x6 = sc.nextInt();
        int y6 = sc.nextInt();

        //area of bullboards
        int b1A = (x2-x1)*(y2-y1);
        int b2A = (x4-x3)*(y4-y3);

        //overlap of b1 and truck
        int b1w = Math.max(0, Math.min(x2, x6) - Math.max(x1, x5));
        int b1l = Math.max(0, Math.min(y2, y6) - Math.max(y1, y5));
        int b1overlap = b1w * b1l;

        //overlap of b2 and truck
        int b2w = Math.max(0, Math.min(x4, x6) - Math.max(x3, x5));
        int b2l = Math.max(0, Math.min(y4, y6) - Math.max(y3, y5));
        int b2overlap = b2w * b2l;

        //visible area of billboards
        int b1visible = b1A-b1overlap;
        int b2visible = b2A-b2overlap;

        int total = b1visible+b2visible;
        pw.println(total);
        pw.close();

    }
}