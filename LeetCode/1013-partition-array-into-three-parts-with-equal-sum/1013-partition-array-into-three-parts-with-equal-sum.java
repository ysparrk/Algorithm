class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int totalSum = Arrays.stream(arr).sum();
      
        if (totalSum % 3 != 0) {
            return false;
        }
      
        int targetSum = totalSum / 3;
      
        int partCount = 0;
        int curSum = 0;
      
        for (int num : arr) {
            curSum += num;
          
            if (curSum == targetSum) {
                partCount++;
                curSum = 0;
            }
        }
      
        return partCount >= 3;
    }
}
