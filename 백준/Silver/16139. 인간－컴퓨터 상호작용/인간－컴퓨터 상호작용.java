import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static String S;
    private static int q, N;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. input
        S = br.readLine();
        N = S.length();
        
        // 2. 누적합
        dp = new int[26][N + 1];
        prefix_sum();
        

        // 3. result
        q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int sIdx = st.nextToken().charAt(0) - 97;
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(dp[sIdx][r+1] - dp[sIdx][l] + "\n");
        }

        System.out.println(sb);
    }
    
    // 누적합
    private static void prefix_sum() {
        
        for (int i = 1; i <= S.length(); i++) {
            int idx = S.charAt(i-1) - 97;

            dp[idx][i] = 1;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] += dp[i][j - 1];
            }
        }
    }
}