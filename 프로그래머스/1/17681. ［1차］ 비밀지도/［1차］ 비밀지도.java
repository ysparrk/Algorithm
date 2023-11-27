class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String makeCode;
        
        for (int i = 0; i < n; i++) {
            // 하나라도 1이면 1
            // str.length()가 N보다 작을 경우 공백 추가
            makeCode = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
            makeCode = makeCode.substring(makeCode.length() - n);
            makeCode = makeCode.replaceAll("1", "#");
            makeCode = makeCode.replaceAll("0", " ");            
            answer[i] = makeCode;
        }
        
        return answer;
    }
}