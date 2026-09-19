class Solution {
    public boolean canJump(int[] nums) {

        int maxIdx = 0;  //지금까지 도달할 수 있는 최대 인덱스

        for (int i = 0; i < nums.length; i++) {
            if (maxIdx < i) {
                return false;
            }

            maxIdx = Math.max(maxIdx, i + nums[i]);
        }

        return true;
    }
}