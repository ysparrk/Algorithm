class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int curIdx = 0; curIdx < nums.length; curIdx++) {
            int prevIdx = map.getOrDefault(nums[curIdx], -1000000);

            if (curIdx - prevIdx <= k) {
                return true;
            }

            map.put(nums[curIdx], curIdx);
        }

        return false;
    }
}