import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;
    private static int[][] cost, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cost = new int[N][2];
        dp = new int[N][1000010];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }

        //2. 백트래킹
        System.out.println(recur(0, 0));
    }

    private static int recur(int cur, int w) {
        if (w > K) return Integer.MIN_VALUE;

        if (cur == N) return 0;

        if (dp[cur][w] != -1) return dp[cur][w];

        //cur을 선택한다/안한다
        dp[cur][w] = Integer.max(recur(cur + 1, w + cost[cur][0]) + cost[cur][1], recur(cur + 1, w));
        return dp[cur][w];
    }
}