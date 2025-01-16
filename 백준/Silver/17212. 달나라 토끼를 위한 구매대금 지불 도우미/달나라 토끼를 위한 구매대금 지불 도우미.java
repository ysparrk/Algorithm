import java.io.*;

public class Main {
    private static int N;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[100001];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 1;
        dp[6] = 2;
        dp[7] = 1;

        for (int i = 8; i <= N; i++) {
            dp[i] = Math.min(dp[i-1], Math.min(dp[i-2], Math.min(dp[i-5], dp[i-7]))) + 1;
        }
        System.out.println(dp[N]);
    }
}