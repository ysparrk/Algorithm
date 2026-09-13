class Solution {
    /*
    
    nums, true 두 부분집합의 요소 합이 같으면 true, false
    
    
     */
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        //절반으로 안나뉘어 떨어지면 false
        if (totalSum % 2 == 1) {
            return false;
        }

        int N = nums.length;
        int target = totalSum / 2;  //부분집합의 합이 total의 절반이 되는지 구하기

        boolean[][] dp = new boolean[N + 1][target + 1]; //i개의 숫자를 사용해서 합 j를 만들 수 있는가

        dp[0][0] = true;  //0개의 숫자를 사용해서 합 0을 만들 수 있다

        for (int i = 1; i <= N; i++) {
            int cur = nums[i - 1];

            for (int j = 0; j <= target; j++) {
                //현재 숫자 사용X
                dp[i][j] = dp[i - 1][j];

                //현재 숫자 사용O
                if (j >= cur) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - cur];
                }
            }
        }

        return dp[N][target];
    }
}