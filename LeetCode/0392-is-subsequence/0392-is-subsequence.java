class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int i = 0;  //s 포인터
        int j = 0;  //t 포인터

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            //t의 포인터는 항상 증가
            j++;
        }

        return i == s.length();
    }
}