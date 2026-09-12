class Solution {
    private int[] nums;

    public void rotate(int[] nums, int k) {

        k = k % nums.length;
        swapSort(nums, 0, nums.length - 1);
        swapSort(nums, 0, k - 1);
        swapSort(nums, k, nums.length - 1);
    }

    private void swapSort(int[] nums, int start, int end) {
        
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}