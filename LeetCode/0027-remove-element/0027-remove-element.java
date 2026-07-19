class Solution {
    public int removeElement(int[] nums, int val) {
        int N = nums.length;
        int lastIdx = N - 1;

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (nums[i] != val) {
                result++;
            } else {
                //nums[i]를 배열의 끝으로 옮긴다
                int tmp = nums[lastIdx];
                nums[lastIdx] = nums[i];
                nums[i] = tmp;
                lastIdx--;
                i--;
            }

            if (i == lastIdx) {
                break;
            }
        }

        return result;
    }
}