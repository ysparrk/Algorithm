class Solution {

    public int maxArea(int[] height) {
        
        int N = height.length;

        int start = 0;
        int end = N - 1;

        int result = 0;
        while (start < end) {
            int w = end - start;
            int h = Math.min(height[start], height[end]);
            int water = w * h;

            result = Math.max(result, water);

            //이동 -> 작은 쪽을 이동시킨다
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}