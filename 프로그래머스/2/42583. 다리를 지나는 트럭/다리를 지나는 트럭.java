import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < bridge_length; i++) {
            q.offer(0);
        }
        
        //조기종료
        if (bridge_length == 1) {
            return truck_weights.length + 1;
        }
        
        if (truck_weights.length == 1) {
            return bridge_length + 1;
        }
        
        
        int idx = 0;  // 다음 올릴 트럭 인덱스
        int curWeight = 0; // 현재 다리 위의 트럭 무게
        int second = 0;
        
        while (idx < truck_weights.length) {
            
            curWeight -= q.poll();
            second++;
            
            //새로운 트럭을 올릴 수 있는지 확인
            int nextWeight = truck_weights[idx];
            if (curWeight + nextWeight <= weight) {
                q.offer(nextWeight);
                curWeight += nextWeight;
                idx++;
            } else {
                q.offer(0);
            }
            
        }
        
        
        return second + bridge_length;
    }
}