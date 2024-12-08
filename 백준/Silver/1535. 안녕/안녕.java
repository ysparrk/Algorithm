import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] L, J;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        L = new int[N + 1];
        J = new int[N + 1];
        dp = new int[N + 1][100];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            L[i] = Integer.parseInt(st1.nextToken());
            J[i] = Integer.parseInt(st2.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 99; j++) {
                if (L[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - L[i]] + J[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][99]);
    }
}