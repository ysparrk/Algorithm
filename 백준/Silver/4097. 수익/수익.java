import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            int[] dp = new int[N + 1];
            dp[1] = Integer.parseInt(br.readLine());

            int max = -10001;
            for (int i = 2; i <= N; i++) {
                int n = Integer.parseInt(br.readLine());
                dp[i] = Math.max(n, dp[i - 1] + n);
                max = Math.max(max, dp[i]);
            }

            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}