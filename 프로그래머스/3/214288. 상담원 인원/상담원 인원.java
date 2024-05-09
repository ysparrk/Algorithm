import java.util.*;

class Solution {
    
    
    static ArrayList<ArrayList<Node>> parti = new ArrayList<>();
    static int[][] wait_table;
    static int rlt = Integer.MAX_VALUE;
    
    
    //1. 유형에 따른 node 리스트 만들기
    static void makeNodeList(int k, int[][] reqs) {
        
        // 유형 넣기
        for (int i = 0; i <= k; i++) {
            parti.add(new ArrayList<>());
        }
        
        // parti에 넣기
        for (int[] r : reqs) {
            parti.get(r[2]).add(new Node(r[0], r[1]));
        }
    
    }
    
    //2.  wait table 만들기
    static void makeWaitTable(int k, int n) {
    
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n-k+2; j++) {
                
                int time_tmp = 0;
               
                PriorityQueue<Integer> q = new PriorityQueue<>();
            
                for (Node now : parti.get(i)) {
                    if (q.size() < j) {
                        q.add(now.start + now.time);
                    } 
                    else {
                        int min_tmp = q.poll();  //최소 값 반환
                        
                        if (min_tmp <= now.start) {
                            q.add(now.start + now.time);
                        } else {
                            time_tmp += (min_tmp - now.start);
                            q.add(min_tmp + now.time);
                        }
                    }
                }
                wait_table[i][j] = time_tmp;
            }   
        }
    }
    
    // 3. dfs - wait table에서의 최소 시간 찾기
    static int dfs(int now, int tmp_n, int time, int n, int k) {

        if (now == k && (tmp_n > n || tmp_n < n)) {
            return 0;
        } else if (now == k && tmp_n == n) {
            rlt = Math.min(rlt, time);
            return 0;
        } else {
            
        }
        
        // dfs
        for (int j = 1; j < n-k+2; j++) {
            dfs(now + 1, tmp_n + j, time + wait_table[now+1][j], n, k);
        }
        
        return 0;
    }
    
    
    // 4. result
    public int solution(int k, int n, int[][] reqs) {
        wait_table = new int[k+1][n-k+2];
        
        makeNodeList(k, reqs);
        
        makeWaitTable(k, n);
        
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n-k+2; j++) {
                System.out.print(wait_table[i][j] + " ");
            }
            System.out.println();
        }
        
        dfs(0, 0, 0, n, k);
        
        return rlt;
    }
    
    
    static class Node {
        int start;
        int time;
        
        Node (int start, int time) {
            this.start = start;
            this.time = time;
        }
    }
}