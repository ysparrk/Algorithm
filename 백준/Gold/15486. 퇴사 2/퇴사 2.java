import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] cost;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        N = Integer.parseInt(br.readLine());
        cost = new int[N][2];
        dp = new int[N];
        Arrays.fill(dp, -1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
        }

        //2. dp
        System.out.println(recur(0));
    }

    private static int recur(int cur) {
        //현재 cur일이고, 앞으로 일을 최선을 다해 고를 때 벌 수 있는 최대 이익을 리턴하는 함수

        if (cur > N) return Integer.MIN_VALUE;

        if (cur == N) return 0;

        if (dp[cur] != -1) return dp[cur];

        //선택 하거나 안하거나
        dp[cur] = Integer.max(recur(cur + cost[cur][0]) + cost[cur][1], recur(cur + 1));
        return dp[cur];
    }
}