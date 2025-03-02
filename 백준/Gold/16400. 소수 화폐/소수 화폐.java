import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int MOD = 123_456_789;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        List<Integer> pn = getPrimeNums(40000);
        
        dp = new int[N + 1];
        dp[0] = 1;
        for (int tmp : pn) {
            for (int i = tmp; i <= N; i++) {
                dp[i] = (dp[i] + dp[i - tmp]) % MOD;
            }
        }
        System.out.println(dp[N]);
    }

    //에라토네스의 체
    private static List<Integer> getPrimeNums(int limit) {
        List<Integer> pn = new ArrayList<>();

        boolean[] isPrime = new boolean[limit + 1];

        isPrime[0] = true;
        isPrime[1] = true;

        for (int i = 2; i * i <= limit; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!isPrime[i]) pn.add(i);
        }

        return pn;
    }
}