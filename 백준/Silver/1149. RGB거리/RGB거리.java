import java.io.*;
import java.util.*;

public class Main {
    static int[][] home;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 1. input
        home = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. dp
        dp = new int[N][3];

        // 초기값 넣기
        for (int j = 0; j < 3; j++) {
            dp[0][j] = home[0][j];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = find_min(i, j) + home[i][j];
            }
        }
        System.out.println(Arrays.stream(dp[N - 1]).min().orElse(0));
    }

    /**
     * y가 아닌 부분에서 이전 row의 최솟값을 찾는다.
     */
    public static int find_min(int x, int y) {
        int rlt = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            if (j != y) {
                rlt = Math.min(dp[x - 1][j], rlt);
            }
        }
        return rlt;
    }
}