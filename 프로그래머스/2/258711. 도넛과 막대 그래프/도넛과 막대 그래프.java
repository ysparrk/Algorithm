import java.util.*;

class Solution {
    
    Map<Integer, int[]> nodeCnt = new HashMap<>();  //(out, in) 카운트
    int[] rlt = {0, 0, 0, 0};

    //1. HashMap에 key에 대한 (out, in) 간선 수 세기
    private void init(int[][] edges) {
        
        Arrays.stream(edges).forEach(edge -> {
            int a = edge[0];
            int b = edge[1];
            
            if (!nodeCnt.containsKey(a)) {
                nodeCnt.put(a, new int[] {0, 0});
            }
            
            if (!nodeCnt.containsKey(b)) {
                nodeCnt.put(b, new int[] {0, 0});
            }
            
            nodeCnt.get(a)[0]++;
            nodeCnt.get(b)[1]++;
            
    
        });
    
        
    }
    
    //2. 결과
    private void get_result() {
        /**
         * 1) 생성된 정점
         *  - out 2개 이상, in 0 **
         * 2) 도넛
         *  - 모두 out 1, in 1
         *  - 생성된 정점에 이어진 정점 out 1, in 2 ** -> 하지만, 8자와 겹칠 수 있음
         * 3) 막대
         *  - 하나의 정점이 out 0, in 1 이상 **
         *  - 나머지 out 1, in 1
         * 4) 8자
         *  - 가운데 정점 out 2 이상, in 2 이상 **
         *  - 나머지 out1, in 1
         */
        
        int[] out_in;
        for (int key : nodeCnt.keySet()) {
            out_in = nodeCnt.get(key);
            
            if (out_in[0] >= 2 && out_in[1] == 0) {
                rlt[0] = key;
            }
            else if (out_in[0] == 0 && out_in[1] >= 1) {
                rlt[2]++;
            } 
            else if (out_in[0] >= 2 && out_in[1] >= 2) {
                rlt[3]++;
            }
        }
        
        rlt[1] = nodeCnt.get(rlt[0])[0] - (rlt[2] + rlt[3]);  //도넛 마지막에 계산
        
    }
    
    public int[] solution(int[][] edges) {

        init(edges);
        get_result();
        
        return rlt;
    }
}