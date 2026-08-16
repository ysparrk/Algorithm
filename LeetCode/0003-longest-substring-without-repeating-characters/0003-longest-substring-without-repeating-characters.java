class Solution {
    public int lengthOfLongestSubstring(String s) {

        int[] charList = new int[128];

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char cur = s.charAt(right);

            charList[cur]++;

            //같은 문자가 나온다면 left 오른쪽으로 이동
            while (charList[cur] > 1) {
                charList[s.charAt(left)]--; 
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}