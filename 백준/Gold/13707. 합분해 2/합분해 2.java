import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;
    private static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[5001][5001];
        
        //k개의 숫자로 만들 수 있는 경우
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < K + 1; j++) {
                if (i == 1) dp[i][j] = j;
                else dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1_000_000_000;
            }
        }

        System.out.println(dp[N][K]);
    }
}