class Solution {
    public int firstUniqChar(String s) {
        int[] cnt = new int[26];

        int len = s.length();

        for (int i = 0; i < len; i++) {
            int charIdx = s.charAt(i) - 'a';
            cnt[charIdx]++;
        }

        for (int i = 0; i < len; i++) {
            int charIdx = s.charAt(i) - 'a';
            if (cnt[charIdx] == 1) {
                return i;
            }
        }
        return -1;
    }
}