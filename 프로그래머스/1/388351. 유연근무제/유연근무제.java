class Solution {
    
    private int N;
    private int[] isFailed;
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        N = schedules.length;  //직원 수
        isFailed = new int[N];
        
        int answer = 0;
        
        
        int satIdx = 6 - startday; 
        int sunIdx = 7 - startday;
        
        if (startday == 7) {
            satIdx = 6;
        }
        
        
        for (int d = 0; d < 7; d++) {

            if (d == satIdx || d == sunIdx) {
                continue;
            }
            
            for (int i = 0; i < N; i++) {
                int s = changeToMinute(schedules[i]) + 10;
                int time = changeToMinute(timelogs[i][d]);
                
                if (isFailed[i] == 1) {
                    continue;
                }
                
                if (s < time) {
                    isFailed[i] = 1;
                    continue;
                }
            }
        }

        //결과 확인
        for (int i = 0; i < N; i++) {
            if (isFailed[i] == 0) {
                answer++;
            }
        }
        
        return answer;
    }
    
    
    private int changeToMinute(int time) {
        int hour = time / 100;
        int minute = time % 100;
        
        return hour * 60 + minute;
    }
}


