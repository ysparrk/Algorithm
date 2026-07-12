class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;

        int groupCount = gcd(n, k);   //그룹의 수
        long answer = 0;

        for (int i = 0; i < groupCount; i++) {
            List<Integer> group = new ArrayList<>();

            //같은 그룹에 속하는 원소 수집
            for (int j = i; j < n; j += groupCount) {
                group.add(arr[j]);
            }

            Collections.sort(group);

            int mid = group.get(group.size() / 2);

            //모든 값을 중앙값으로 변경
            for (int v : group) {
                answer += Math.abs(v - mid);
            }
        }
        return answer;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }

        return a;
    }
}