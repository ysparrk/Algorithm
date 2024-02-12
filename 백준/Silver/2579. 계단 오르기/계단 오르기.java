import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] point = new int[N+1];

        for (int i = 1; i < N + 1; i++) {
            point[i] = Integer.parseInt(br.readLine());
        }

        /**
         * dp
         * n번째 계단을 밟는 경우 -> 1) n-3, n-1, n  2) n-2, n
         * 1. 1 ~ 2번째 계단 default
         * 2. 3번째 ~
         */
        int[] dp = new int[N + 1];

        switch (N) {
            case 1:
                dp[1] = point[1];
                break;
                
            case 2:
                dp[2] = point[1] + point[2];
                break;
                
            default:
                dp[1] = point[1];
                dp[2] = point[1] + point[2];
                
                for (int i = 3; i < N + 1; i++) {
                    dp[i] = Math.max(dp[i - 3] + point[i - 1], dp[i - 2]) + point[i];
                }

        }

        System.out.println(dp[N]);
    }
}