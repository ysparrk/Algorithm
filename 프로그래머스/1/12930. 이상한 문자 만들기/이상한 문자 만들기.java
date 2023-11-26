class Solution {
    public String solution(String s) {
        String answer = "";
        int cnt = 0;
        String[] strArray = s.split("");

        for (String str : strArray) {
            cnt = str.contains(" ") ? 0 : cnt + 1;  // 새로운 단어 -> cnt 초기화
            answer += cnt % 2 == 0 ? str.toLowerCase() : str.toUpperCase();
        }
    
        return answer;
    }
}