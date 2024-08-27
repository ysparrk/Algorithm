import java.io.*;

public class Main {

    private static int N;
    private static long[] dp;
    private static int MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new long[3]; //W, H, E

        long rlt = 0;
        String s = br.readLine();
        for (int i = 0; i < N; i++) {

            switch (s.charAt(i)) {
                case 'W':
                    dp[0] += 1;
                    dp[0] %= MOD;
                    break;
                case 'H':
                    dp[1] += dp[0]; //새로운 H, WH 경우의 수 추가
                    dp[1] %= MOD;
                    break;
                case 'E':
                    rlt += dp[2]; //이전까지의 WH 조합에 대해 더하기

                    //새로운 E가 오게 될때 완성되는 조합의 수 구해놓기
                    dp[2] *= 2;   //새로운 E를 통해 기존 조합 2배
                    dp[2] += dp[1]; //새로운 E를 통해 새로운 조합 1배
                    dp[2] %= MOD;
                    break;
            }
        }
        System.out.println(rlt % MOD);
    }
}