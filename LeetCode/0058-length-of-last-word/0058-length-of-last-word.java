class Solution {
    public int lengthOfLastWord(String s) {
        int endIdx = s.length() - 1;
      
        while (endIdx >= 0 && s.charAt(endIdx) == ' ') {
            endIdx--;
        }
      
        int startIdx = endIdx;
      
        while (startIdx >= 0 && s.charAt(startIdx) != ' ') {
            startIdx--;
        }
      
        return endIdx - startIdx;
    }
}