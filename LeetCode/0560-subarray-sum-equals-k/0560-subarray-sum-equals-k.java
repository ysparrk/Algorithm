class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int cnt = 0;
        int curSum = 0;

        for (int n : nums) {
            curSum += n;

            cnt += map.getOrDefault(curSum - k, 0);

            map.merge(curSum, 1, Integer::sum);
        }

        return cnt;
    }
}