import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //2. dp
        dp = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            find_max(i, Integer.parseInt(br.readLine()));
        }

        System.out.println(dp[N][0]);

    }

    //2. dp
    public static void find_max(int idx, int run) {
        /**
         * dp[idx][지침지수]
         * 목표: dp[N][0]을 구하고 싶다!
         * dp[idx][0] = max(dp[idx-1][1], [idx-2][2] ...중에서의 최댓값)
         */

        //1) 초기값
        dp[idx][0] = dp[idx - 1][0];

        //2) 달리기: (idx-1)의 (지침지수-1)인 곳에서 달려온다
        for (int t = 1; t < M + 1; t++) {
            dp[idx][t] = dp[idx - 1][t - 1] + run;
        }

        //3) 지침지수==0 일때의 최댓값
        for (int t = 1; t < M + 1 && idx > t; t++) {
            dp[idx][0] = Math.max(dp[idx][0], dp[idx - t][t]);
        }
    }
}