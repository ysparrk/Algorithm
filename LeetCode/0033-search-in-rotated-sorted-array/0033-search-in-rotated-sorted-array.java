class Solution {
    public int search(int[] nums, int target) {

        return binarySearch(nums, 0, nums.length - 1, target);
        
    }

    private int binarySearch(int[] nums, int start,  int end, int target) {

        if (start >= end) {
            return (nums[start] == target) ? start : -1;
        }

        int tmp = -1;
        int mid = (start + end) / 2;

        if (nums[mid] == target) {
            tmp = mid;
        } else {
            tmp = binarySearch(nums, start, mid - 1, target);
            //start~mid-1 사이에 없으면 mid + 1 ~ end 탐색
            if (tmp < 0) {
                tmp = binarySearch(nums, mid + 1, end, target);
            }
        }
        return tmp;
    }
}