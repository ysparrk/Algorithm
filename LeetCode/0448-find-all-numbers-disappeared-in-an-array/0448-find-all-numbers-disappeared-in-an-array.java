class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int arrayLength = nums.length;
      
        boolean[] isPresent = new boolean[arrayLength + 1];
      
        for (int number : nums) {
            isPresent[number] = true;
        }
      
        List<Integer> missingNumbers = new ArrayList<>();
      
        for (int i = 1; i <= arrayLength; i++) {
            if (!isPresent[i]) {
                missingNumbers.add(i);
            }
        }
      
        return missingNumbers;
    }
}
