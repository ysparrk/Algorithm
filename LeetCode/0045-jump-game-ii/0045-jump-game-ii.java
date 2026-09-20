class Solution {
    public int jump(int[] nums) {
        
        int result = 0;  //지금까지 사용한 점프 횟수
        int max = 0;     //현재 범위 안에서 다음 점프로 갈 수 있는 가장 먼 곳
        int last = 0;    //현재 점프로 갈 수 있는 범위의 끝

        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);

            if (i == last) {
                result++;
                last = max;   
            }
        }

        return result;
    }
}