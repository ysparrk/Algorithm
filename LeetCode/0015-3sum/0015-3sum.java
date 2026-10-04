class Solution {

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int pivot;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                continue;
            }

            //중복 제거
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            pivot = nums[i];
            twoSum(nums, pivot, i);
        }


        return list;
    }

    public void twoSum(int[] nums, int pivot, int idx) {
        
        int minIdx = idx + 1;
        int maxIdx = nums.length - 1;
        int target = pivot * -1;

        int sum;
        while (minIdx < maxIdx) {
            
            sum = nums[minIdx] + nums[maxIdx];

            if (sum == target) {
                list.add(Arrays.asList(pivot, nums[minIdx], nums[maxIdx]));

                //중복 제거
                while (minIdx < maxIdx && nums[minIdx] == nums[minIdx + 1]) {
                    minIdx++;
                }

                while (minIdx < maxIdx && nums[maxIdx] == nums[maxIdx - 1]) {
                    maxIdx--;
                }
                minIdx++;
                maxIdx--;
            } else if (sum < target) {
                minIdx++;
            } else {
                maxIdx--;
            }
        }
    }
}