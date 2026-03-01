import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static double[] dp;
    private static double rlt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new double[N + 1];

        for (int i = 1; i < N; i++) {
            double num = Double.parseDouble(br.readLine());
            dp[i] = Math.max(num, dp[i - 1] * num);
            rlt = Math.max(rlt, dp[i]);
        }
        System.out.print(String.format("%.3f", rlt));
    }
}
