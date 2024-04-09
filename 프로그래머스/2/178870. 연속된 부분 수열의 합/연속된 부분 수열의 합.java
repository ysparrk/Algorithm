/*
1) 0 ~ N까지 누적합을 구해 놓는다
2) two pointer로 사이 값이 K가 되는 것들을 찾는다
*/

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int N = sequence.length;
        
        // 1. 0 ~ N까지 누적합 만들기
        int[] sums = new int[N];
        sums[0] = sequence[0];
        for (int i = 1; i < N; i++) {
            sums[i] += (sums[i - 1] + sequence[i]);
        }
        
        // 2. 투포인터
        int left = 0, right = 0;
        int rltLeft = 0, rltRight = 0, rltLen = Integer.MAX_VALUE;
        while (left <= right && right < N) {
            int tmpSum = sums[right] - sums[left] + sequence[left];  // left ~ right까지 합
            int tmpLen = right - left + 1; // 수열 길이
            
            if (tmpSum == k) {
                //2-1) k랑 같으면 수열길이 비교
                if (tmpLen < rltLen) {
                    rltLeft = left;
                    rltRight = right;
                    rltLen = tmpLen;
                }
                left++;
                right++;
                
            } else if (tmpSum < k) {
                //2-2) k보다 작으면 -> 더 더한다
                right++;
            } else {
                //2-3) k보다 크면 -> 왼쪽에서 뺀다
                left++;
            }
        }
        
        int[] answer = {rltLeft, rltRight};
        
        return answer;
    }
}