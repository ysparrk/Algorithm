import java.io.*;

public class Main {
    private static int N;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[100001];

        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 6; i <= N; i++) {
            if (dp[i-2] == -1 && dp[i-5] == -1) {
                dp[i] = -1;
            } else if (dp[i-2] == -1) {
                dp[i] = dp[i-5] + 1;
            } else if (dp[i-5] == -1) {
                dp[i] = dp[i-2] + 1;
            } else {
                dp[i] = Math.min(dp[i-2], dp[i-5]) + 1;
            }
        }
        System.out.print(dp[N]);
    }
}