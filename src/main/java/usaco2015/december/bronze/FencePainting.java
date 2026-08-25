import java.util.*;
import java.io.*;

class FencePainting{
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("paint.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("paint.out"));

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        int total = (b-a)+(d-c);

        int overlap = Math.max(0, Math.min(b,d)-Math.max(a,c));

        int paintTotal = total-overlap;
        pw.println(paintTotal);
        pw.close();
        sc.close();
    }
}