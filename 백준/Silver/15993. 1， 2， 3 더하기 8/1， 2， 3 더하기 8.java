import java.io.*;

public class Main {
    private static int N, T;
    private static int INF = 1_000_000_009;
    private static long dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[100001][2];
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 2;
        dp[3][1] = 2;

        for(int i = 4; i <= 100000; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 2][1] + dp[i - 3][1]) % INF;
            dp[i][1] = (dp[i - 1][0] + dp[i - 2][0] + dp[i - 3][0]) % INF;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            T = Integer.parseInt(br.readLine());
            long odd = dp[T][1] % INF;
            long even = dp[T][0] % INF;

            sb.append(odd + " " + even + "\n");
        }
        System.out.println(sb);
    }
}