class Solution {
    public List<Integer> pancakeSort(int[] arr) {
    
        int N = arr.length;
        List<Integer> result = new ArrayList<>();

        //뒤 부터 정렬
        for (int target = N; target > 1; target--) {
            int idx = 0;

            for (int i = 0; i < target; i++) {
                if (arr[i] == target) {
                    idx = i;
                    break;
                }
            }

            if (idx == target - 1) {
                continue;
            }

            if (idx != 0) {
                reverse(arr, idx + 1);
                result.add(idx + 1);
            }

            reverse(arr, target);
            result.add(target);
        }
        return result;
    }

    private void reverse (int[] arr, int k) {
        int start = 0;
        int end = k - 1;

        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;

            start++;
            end--;
        }
    }
}