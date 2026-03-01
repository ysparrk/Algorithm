import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    private static int N;
    private static Long[][] dp;
    private static long MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dp = new Long[N + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        long rlt = 0;
        //N번째 자릿수일때 자릿값이 1~9까지인 경
        for(int i = 1; i <= 9; i++) {
            rlt += recur(N, i);
        }
        System.out.println(rlt % MOD);

    }


    /**
     * @param digit 자릿수
     * @param val   자릿값
     */
    private static long recur(int digit, int val) {

        //첫번째 자리수 -> 탐색 X
        if (digit == 1) {
            return dp[digit][val];
        }

        // 해당 자리수의 자리값에 대해 탐색하지 않았을 경우
        if(dp[digit][val] == null) {
            if(val == 0) {
                //0의 이전은 1
                dp[digit][val] = recur(digit - 1 ,1);
            }
            else if(val== 9) {
                //9의 이전은 8
                dp[digit][val] = recur(digit - 1, 8);
            }
            else {
                dp[digit][val] = recur(digit - 1, val - 1) + recur(digit - 1, val + 1);
            }
        }
        return dp[digit][val] % MOD;

    }
}
