class Solution {
    public boolean canJump(int[] nums) {
        //첫번째 인덱스 초기에 위치 점프거리
        int maxIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (maxIdx < i) {
                return false;
            }

            maxIdx = Math.max(maxIdx, i + nums[i]);
        }

        return true;
    }
}