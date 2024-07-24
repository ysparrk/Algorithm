class Solution {
    public int solution(String s) {
		char start = s.charAt(0);
		int startCnt = 0;
		int restCnt = 0;
		int rlt = 0;
        
		for (int i = 0; i < s.length(); i++) {
			if (startCnt == restCnt) {
				rlt++;
				start = s.charAt(i);
			}
            
			if (s.charAt(i) == start) startCnt++;
			else restCnt++;
		}
		return rlt;
	}
}