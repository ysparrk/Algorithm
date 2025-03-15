import java.io.*;
import java.util.*;

public class Main {
    private static long X, Y, Z;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        Z = Y * 100 / X;

        if (Z == 100 || Z == 99) {
            System.out.println(-1);
            return;
        }

        long start = 1;
        long end = (int) X;

        while (start < end) {

            long mid = (start + end) / 2;

            long tmpX = X + mid;
            long tmpY = Y + mid;

            long tmp = tmpY * 100 / tmpX;

            if (tmp > Z) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);
    }
}