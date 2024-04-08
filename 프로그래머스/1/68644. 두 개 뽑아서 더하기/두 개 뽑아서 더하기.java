import java.util.*;


class Solution {
    public int[] solution(int[] numbers) {
        // 1. ArrayList 생성
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        int N = numbers.length;
        
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                int num = numbers[i] + numbers[j];
                // 중복 X
                if (tmp.indexOf(num) < 0) {
                    tmp.add(num);
                }
            }
        }
        
        // 2. result
        int[] rlt = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            rlt[i] = tmp.get(i);
        }
        Arrays.sort(rlt);
        
        return rlt;
    }
}