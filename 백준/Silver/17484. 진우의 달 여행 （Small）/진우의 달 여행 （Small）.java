import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        //1. input
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] load = new int[N + 1][M + 2];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < M + 1; j++) {

                load[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /**
         * 2. 
         * dp(0, 0, 0)
         * (i, j)로 내려오는 경우 같은 방향을 제외하고 최솟값을 해당 자리의 연료 값과 더한다.
         * (왼쪽 아래, 아래, 오른쪽 아래)
         */
        long[][][] dp = new long[N + 1][M + 2][3];


        for (int i = 1; i < N + 1; i++) {
            for (int j = 0; j < M + 2; j++) {
                if (j == 0 || j == M + 1) {
                    dp[i][j][0] = Integer.MAX_VALUE;
                    dp[i][j][1] = Integer.MAX_VALUE;
                    dp[i][j][2] = Integer.MAX_VALUE;
                } else {
                    dp[i][j][0] = load[i][j] + Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]);  //왼아
                    dp[i][j][1] = load[i][j] + Math.min(dp[i-1][j][0], dp[i-1][j][2]);  //아래
                    dp[i][j][2] = load[i][j] + Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]);  //오아
                }

            }
        }
        
        //3. rlt
        long minRlt = (long) Integer.MAX_VALUE;
        for (int j = 1; j < M+1; j++) {
            for (int k = 0; k < 3; k++) {
                minRlt = Math.min(dp[N][j][k], minRlt);
            }

        }
        System.out.println(minRlt);
    }
}