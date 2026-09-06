class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lineCount = 1;
        int cur = 0;
      
        for (int i = 0; i < s.length(); i++) {
            int charWidth = widths[s.charAt(i) - 'a'];
          
            if (cur + charWidth <= 100) {
                cur += charWidth;
            } else {
                lineCount++;
                cur = charWidth;
            }
        }
      
        return new int[] {lineCount, cur};
    }
}