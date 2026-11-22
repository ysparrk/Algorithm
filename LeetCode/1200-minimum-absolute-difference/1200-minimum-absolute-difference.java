class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
      
        int arrayLength = arr.length;
      
        int min = 1 << 30;
      
        for (int i = 0; i < arrayLength - 1; i++) {
            int currentDifference = arr[i + 1] - arr[i];
            min = Math.min(min, currentDifference);
        }
      
        List<List<Integer>> result = new ArrayList<>();
      
        for (int i = 0; i < arrayLength - 1; i++) {
            if (arr[i + 1] - arr[i] == min) {
                result.add(List.of(arr[i], arr[i + 1]));
            }
        }
      
        return result;
    }
}
