class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length]; //i번째 문자를 마지막으로 할 때의 최대길이
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}