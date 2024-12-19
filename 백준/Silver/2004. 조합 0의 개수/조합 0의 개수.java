import java.io.*;
import java.util.*;

public class Main {
    private static long N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        long cnt5 = powerN(N, 5) - powerN(N - M, 5) - powerN(M, 5);
        long cnt2 = powerN(N, 2) - powerN(N - M, 2) - powerN(M, 2);

        System.out.println(Math.min(cnt5, cnt2));
    }

    private static long powerN(long n, int x) {
        int cnt = 0;

        while (n >= x) {
            cnt += (n / x);
            n /= x;
        }
        return cnt;
    }
}