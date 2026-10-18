class Solution {
    public int passThePillow(int n, int time) {
        int cur = 1;
      
        int direction = 1;
      
        while (time-- > 0) {
            cur += direction;
          
            if (cur == 1 || cur == n) {
                direction *= -1;
            }
        }
      
        return cur;
    }
}
