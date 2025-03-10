import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, K;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[M + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = M; j > 0; j--) {
                for (int k = K; k > 0; k--) {
                    if (x <= j && y <= k) {
                        //주문 처리함
                        dp[j][k] = Math.max(dp[j][k], dp[j - x][k - y] + 1);
                    }
                }
            }
        }
        System.out.println(dp[M][K]);
    }
}