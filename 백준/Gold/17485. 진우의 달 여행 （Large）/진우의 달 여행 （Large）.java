import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] board;
    private static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        dp = new int[N][M][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //시작점 초기화
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                dp[0][j][k] = board[0][j];
            }
        }

        //2. dp
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    dp[i][j][0] = 10000000;
                    dp[i][j][1] = Math.min(dp[i - 1][j][0] + board[i][j], dp[i - 1][j][2] + board[i][j]);
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0] + board[i][j], dp[i - 1][j + 1][1] + board[i][j]);
                }
                else if(j == M - 1) {
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1] + board[i][j], dp[i - 1][j - 1][2] + board[i][j]);
                    dp[i][j][1] = Math.min(dp[i - 1][j][0] + board[i][j], dp[i - 1][j][2] + board[i][j]);
                    dp[i][j][2] = 10000000;
                }
                else {
                    dp[i][j][0] = Math.min(dp[i - 1][j - 1][1] + board[i][j], dp[i - 1][j - 1][2] + board[i][j]);
                    dp[i][j][1] = Math.min(dp[i - 1][j][0] + board[i][j], dp[i - 1][j][2] + board[i][j]);
                    dp[i][j][2] = Math.min(dp[i - 1][j + 1][0] + board[i][j], dp[i - 1][j + 1][1] + board[i][j]);
                }
            }
        }


        //3. rlt
        int rlt = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int k = 0; k < 3; k++) {
                rlt = Math.min(rlt, dp[N - 1][j][k]);
            }
        }
        System.out.println(rlt);
    }
}