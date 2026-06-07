import java.util.*;


class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        
        //모든 구간이 시작 상태로 돌아오는 구간(체크할 구간 최대 초)
        int len = 1;
        for (int i = 0; i < signals.length; i++) {
            int g = signals[i][0];
            int y = signals[i][1];
            int r = signals[i][2];
            
            len *= (g + y + r);
        }
        
        //일치하는 구간의 수
        int[] arr = new int[len + 1];
        
        for (int i = 0; i < signals.length; i++) {
            int g = signals[i][0];
            int y = signals[i][1];
            int r = signals[i][2];
            
            int offset = g + y + r;
            
            //초+노+빨 구간별 체크
            for (int j = 1; j <= len; j += offset) {
                //y초 동안 노란불구간 arr에 체크
                for (int k = 0; k < y; k++) {
                    arr[g + j + k]++;
                }
            }
        }
        
        for (int i = 1; i <= len; i++) {
            //구간의 개수와 일치
            if (arr[i] == signals.length) {
                return i;
            }
        }
        
        return -1;
    }
}