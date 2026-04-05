import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[] memory, cost;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        memory = new int[N];
        cost = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st1.nextToken());
            cost[i] = Integer.parseInt(st2.nextToken());
        }

        //dp[i][j] i번째까지 입력된 앱을 사용할 때 비용 j로 확보 가능한 메모리 크기
        dp = new int[N][100001];
        int rlt = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int m = memory[i];
            int c = cost[i];
            //비용
            for (int j = 0; j <= 10000; j++) {
                //앱이 1개인 경우
                if (i == 0) {
                    //현재 앱의 비용이 j보다 쌀 경우 -> m의 메모리 확보 가능
                    if (j >= c) {
                        dp[i][j] = m;
                    }
                } else {
                    if (j >= c) {
                        //Math.max(현재 앱 포함, 현재 앱 포함하지 않음)
                        dp[i][j] = Math.max(dp[i - 1][j - c] + m, dp[i - 1][j]);
                    } else {
                        //현재 앱의 비용이 커 포함하지 않음
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                //결과
                if (dp[i][j] >= M) {
                    rlt = Math.min(rlt, j);
                }
            }
        }
        System.out.println(rlt);
    }
}