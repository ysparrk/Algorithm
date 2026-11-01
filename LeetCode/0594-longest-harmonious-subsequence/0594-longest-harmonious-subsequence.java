class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
      
        for (int number : nums) {
            frequencyMap.merge(number, 1, Integer::sum);
        }
      
        int maxLength = 0;
      
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int currentNumber = entry.getKey();
            int currentFrequency = entry.getValue();
          
            if (frequencyMap.containsKey(currentNumber + 1)) {
                int harmonicLength = currentFrequency + frequencyMap.get(currentNumber + 1);
              
                maxLength = Math.max(maxLength, harmonicLength);
            }
        }
      
        return maxLength;
    }
}
