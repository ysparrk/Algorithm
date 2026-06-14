class Solution {
    public int solution(int n) {
        long answer = 0;
        
        long[] dp = new long[n + 1];
        long MOD = 1000000007;
        
        dp[0] = 1;
        dp[2] = 3;
        
        for (int i = 4; i <= n; i += 2) {
            dp[i] = (dp[i - 2] * 4 % MOD - dp[i - 4] + MOD) % MOD;
        }
        
        return (int) dp[n];
    }
}