import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    private static int N;
    private static int[] dp, array;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        array = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = array[1];
        for (int i = 1; i <= N; i++) {
            dp[i] = array[i];
            for (int j = 1; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[j] + array[i], dp[i]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        System.out.println(max);

    }
}
