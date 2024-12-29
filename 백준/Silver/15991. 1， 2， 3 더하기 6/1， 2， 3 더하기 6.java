import java.io.*;

public class Main {

    private static int T, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        long[] dp = new long[100_001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;

        for(int i = 6; i <= 100_000; i++)
            dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % 1_000_000_009;

        for(int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            sb.append(dp[N] + "\n");
        }
        System.out.println(sb);
    }
}