import java.io.*;
import java.util.*;

public class Main {
    private static int S, C;
    private static long[] L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        L = new long[S];

        long s = 1;
        long e = 1_000_000_000;
        long sum = 0;
        for (int i = 0; i < S; i++) {
            L[i] = Integer.parseInt(br.readLine());
            sum += L[i];
            e = Math.max(e, L[i]);
        }

        long rlt = 0;
        while (s <= e) {
            long mid = (s + e) / 2;

            int cnt = 0;
            for (int i = 0; i < S; i++) {
                cnt += L[i] / mid;
            }

            if (cnt >= C) {
                s = mid + 1;
                rlt = mid;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(sum - (C * rlt));
    }
}