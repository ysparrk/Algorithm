class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] server = new int[24];
        
        for (int i = 0; i < 24; i++) {
            
            int p = players[i];
            int s = server[i];
            
            if (p / m > s) {
            
                //얼마나 증설해야하는지
                int tmp = (p / m) - s;
                answer += tmp;
                
                int idx = i + k;
                if (idx >= 24) idx = 24;
                
                for (int j = i; j < idx; j++) {
                    server[j] += tmp;
                }   
            }   
        }    
        return answer;
    }
}