class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        //모든 연속된 숫자가 해당 구간에 존재하는지 확인
        List<Integer> result = new ArrayList<>();

        //i -> 시작 숫자(1~9)        
        for (int i = 1; i <= 9; i++) {
            int N = i;  //생성하는 숫자

            for (int j = i + 1; j <= 9; j++) {
                N = N * 10 + j;

                if (N >= low && N <= high) {
                    result.add(N);
                }
            }
        }

        Collections.sort(result);

        return result;
    }
}