class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);  //마지막 글자 하나 제거
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}