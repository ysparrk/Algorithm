class Solution {
    public int maxProduct(int[] nums) {
        int maxVal = nums[0];
        int minVal = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num < 0) {
                //음수가 나오면 max, min이 바뀜
                int tmp = maxVal;
                maxVal = minVal;
                minVal = tmp;
            }

            maxVal = Math.max(num, maxVal * num);
            minVal = Math.min(num, minVal * num);

            result = Math.max(result, maxVal);
        }

        return result;
    }
}