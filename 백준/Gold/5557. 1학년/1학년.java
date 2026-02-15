import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] nums;
    private static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        dp = new long[N][21];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //2. dp
        //dp[i][j] i 숫자까지 계산을 진행했을 때의 값이 j일 때, 등식의 수
        //dp[i][j+-nums[i]] += dp[i-1][j]
        dp[0][nums[0]] = 1;

        int plus, minus;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i - 1][j] != 0) {
                    plus = j + nums[i];
                    minus = j - nums[i];

                    if (plus >= 0 && plus <= 20) {
                        dp[i][plus] += dp[i - 1][j];
                    }

                    if (minus >= 0 && minus <= 20) {
                        dp[i][minus] += dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[N - 2][nums[N - 1]]);
    }
}