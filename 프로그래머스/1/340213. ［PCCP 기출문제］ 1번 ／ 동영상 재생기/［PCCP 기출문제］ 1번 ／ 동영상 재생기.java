class Solution {
    private static int current, maxSecond, opStartSecond, opEndSecond;
    
    private static final String PREV = "prev";
    private static final String NEXT = "next";
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        current = getSecond(pos);
        maxSecond = getSecond(video_len);
        opStartSecond = getSecond(op_start);
        opEndSecond = getSecond(op_end);
        
        for (String comm : commands) {
            if (opStartSecond <= current && current <= opEndSecond) {
                current = opEndSecond;
            }
            
            if (PREV.equals(comm)) {
                current = Math.max(current - 10, 0);
            } else {
                current = Math.min(current + 10, maxSecond);
            }
            
            if (opStartSecond <= current && current <= opEndSecond) {
                current = opEndSecond;
            }
        }
        
        int minute = current / 60;
        int second = current % 60;
        
        String answer = "";
        
        answer += (minute < 10 ? "0" + minute : minute);
        answer += ":";
        answer += (second < 10 ? "0" + second : second);
        
        return answer;
    }
    
    private int getSecond(String time) {
        String[] arr = time.split(":");
        
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}