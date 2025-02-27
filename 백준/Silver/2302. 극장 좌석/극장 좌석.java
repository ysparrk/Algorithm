import java.io.*;

public class Main {

    private static int N, M;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dp = new int[41];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int rlt = 1;

        int before = 0;
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(br.readLine());

            rlt *= dp[tmp - before - 1];
            before = tmp;
        }

        rlt *= dp[N - before];

        System.out.println(rlt);
    }
}