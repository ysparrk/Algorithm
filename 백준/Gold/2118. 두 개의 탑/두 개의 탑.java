import java.io.*;

public class Main {
    private static int N;
    private static int[] prefixSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        prefixSum = new int[N + 1];

        int sum = 0;
        for (int i = 0; i < N; i++) {
            prefixSum[i] = Integer.parseInt(br.readLine());
            sum += prefixSum[i];
        }

        int s = 0;
        int e = 0;
        int now = prefixSum[s];
        int rlt = 0;
        while (s <= e && e < N) {
            int min = Math.min(now, sum - now);

            rlt = Math.max(rlt, min);

            if (now == min) {
                e++;
                now += prefixSum[e];
            } else {
                now -= prefixSum[s];
                s++;
            }
        }
        System.out.println(rlt);
    }
}