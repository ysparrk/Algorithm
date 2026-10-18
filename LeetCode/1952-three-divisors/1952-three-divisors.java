class Solution {

    public boolean isThree(int n) {
        int divisorCount = 0;
      
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                divisorCount++;
            }
        }
      
        return divisorCount == 1;
    }
}
