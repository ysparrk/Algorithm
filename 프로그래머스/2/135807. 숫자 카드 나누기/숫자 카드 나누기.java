import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int N = arrayA.length;
        int M = arrayB.length;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        // 각 배열의 최대공약수
        int x = arrayA[0];
        for (int i = 1; i < N; i++) {
            x = gcd(arrayA[i], x);
        }

        int y = arrayB[0];
        for (int i = 1; i < M; i++) {
            y = gcd(arrayB[i], y);
        }
        
        // 다른 배열의 원소 중 하나라도 나눌 수 없는지 확인
        if (!isDivided(arrayB, x)) {
            answer = Math.max(answer, x);
        }

        if (!isDivided(arrayA, y)) {
            answer = Math.max(answer, y);
        }
        
        
        return answer;
    }
    
    //유클리드 호제법
    public int gcd(int x, int y) {	
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
    
    //a로 나눌 수 있는지 확인
    public boolean isDivided(int[] arr, int a) {
        boolean divided = false;
        
        if (a <= 1) {
            return true;
        }
        
        int n = arr.length;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] % a == 0) {
                divided = true;
            }
        }
        
        return divided;
    }
    
}