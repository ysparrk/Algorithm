class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int minIdx = 0;
        int maxIdx = numbers.length - 1;
        int sum;
        while (minIdx < maxIdx) {
            sum = numbers[minIdx] + numbers[maxIdx];

            if (sum == target) {
                return new int[] {minIdx + 1, maxIdx + 1};
            } else if (sum < target) {
                minIdx++;
            } else {
                maxIdx--;
            }
        }

        return new int[] {};
    }
}