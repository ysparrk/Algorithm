import java.io.*;
import java.util.*;

public class Main {
    private static int H, Y;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        dp = new int[Y + 1];
        dp[0] = H;

        for (int i = 1; i <= Y; i++) {
            dp[i] = (int) (dp[i - 1] * 1.05);

            if(i >= 3) {
                dp[i] = Math.max((int)(dp[i - 3] * 1.2), dp[i]);
            }
            if(i >= 5) {
                dp[i] = Math.max((int)(dp[i - 5] * 1.35), dp[i]);
            }
        }
        System.out.println(dp[Y]);
    }
}