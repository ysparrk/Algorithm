class Solution {
  
    public boolean isMonotonic(int[] nums) {
        boolean hasAscendingPattern = false;
      
        boolean hasDescendingPattern = false;
      
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                hasAscendingPattern = true;
            } 
            else if (nums[i - 1] > nums[i]) {
                hasDescendingPattern = true;
            }
          
            if (hasAscendingPattern && hasDescendingPattern) {
                return false;
            }
        }
      
        return true;
    }
}
