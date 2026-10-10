import java.util.*;

class Solution
{
    public int solution(int []A, int []B) {

        int N = A.length;
        int result = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = 0; i < N; i++) {
            result += A[i] * B[N - i - 1];
        }


        return result;
    }
}