import java.io.*;
import java.util.*;

public class Main {
    
    private static int N;
    private static int[] snack;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        snack = new int[N];
        for(int i = 0 ; i < N ; i++){
            snack[i] = Integer.parseInt(br.readLine());
        }
        int result = dp();
        System.out.println(result);
    }

    private static int dp() {
        int[] dp = Arrays.copyOf(snack, N);
        int result= 0;
        for(int i = 0 ; i < N ; i++){
            result = Math.max(result, snack[i]);
            for(int j = i + 1 ; j < N ; j++){
                if(snack[i] < snack[j] && dp[i] + snack[j] > dp[j]) {
                    dp[j] = dp[i] + snack[j];
                    result = Math.max(result,dp[j]);
                }
            }
        }
        return result;
    }
}