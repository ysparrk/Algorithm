class Solution {
    public int arrayNesting(int[] nums) {
        int len = nums.length;
        boolean[] visited = new boolean[len];
        int maxLength = 0;
      
        for (int start = 0; start < len; start++) {
            if (visited[start]) {
                continue;
            }
          
            int cur = nums[start];
            int curLength = 1;
            visited[cur] = true;
          
            while (nums[cur] != nums[start]) {
                cur = nums[cur];
                curLength++;
                visited[cur] = true;
            }
          
            maxLength = Math.max(maxLength, curLength);
        }
      
        return maxLength;
    }
}
