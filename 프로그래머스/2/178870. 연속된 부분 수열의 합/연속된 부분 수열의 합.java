class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int N = sequence.length;
        
        //1. 투포인터
        int end = 0;
        int tmpSum = 0;
        int minLen = N;
        int rltStart = 0, rltEnd = 0;
        for (int start = 0; start < N; start++) {
            //1) 시작점에서 최대 값이 k보다 작으면 -> 계속 더하기
            while (tmpSum < k && end < N) {
                tmpSum += sequence[end];
                end += 1;
            }
            //2) while문 통과 -> k랑 같고, 수열의 길이가 더 작으면 갱신
            if (tmpSum == k && end - start - 1 < minLen) {
                rltStart = start;
                rltEnd = end - 1;
                minLen = end - start - 1;
            }
            tmpSum -= sequence[start];
        }
        
        int[] answer = {rltStart, rltEnd};
        
        return answer;
    }
}