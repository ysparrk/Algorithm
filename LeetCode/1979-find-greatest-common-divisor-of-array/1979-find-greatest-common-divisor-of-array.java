class Solution {
    public int findGCD(int[] nums) {
        int min = 1000;
        int max = 1;

        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        return gcd(min, max);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }

        return a;
    }
}