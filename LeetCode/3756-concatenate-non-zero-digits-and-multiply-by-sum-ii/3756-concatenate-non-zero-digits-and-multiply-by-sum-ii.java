class Solution {

    private static final int MOD = 1_000_000_007;


    public int[] sumAndMultiply(String s, int[][] queries) {
        int N = s.length();

        
        int[] prefixSum = new int[N + 1];   //누적합
        int[] cntNotZero = new int[N + 1];  //0이 아닌 숫자들의 누적 개수
        long[] xList = new long[N + 1];     //0이 아닌 숫자들을 이어붙인 값
        long[] pow10 = new long[N + 1];     //10의 거듭제곱 값 저장

        pow10[0] = 1;
        for (int i = 1; i <= N; i++) {
            pow10[i] = pow10[i - 1] * 10 % MOD;
        }


        for (int i = 1; i <= N; i++) {
            int n = s.charAt(i - 1) - '0';
            prefixSum[i] = prefixSum[i - 1] + n;

            if (n > 0) {
                cntNotZero[i] = cntNotZero[i - 1] + 1;
                xList[i] = (xList[i - 1] * 10 + n) % MOD;
            } else {
                cntNotZero[i] = cntNotZero[i - 1];
                xList[i] = xList[i - 1];
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int sum = prefixSum[r + 1] - prefixSum[l];
            int notZero = cntNotZero[r + 1] - cntNotZero[l];

            //이어붙인 값 구하기
            long left = xList[r + 1];
            long remove = xList[l] * pow10[notZero] % MOD;

            long x = (left - remove + MOD) % MOD;

            result[i] = (int) (x * sum % MOD);
        }

        return result;
    }
}