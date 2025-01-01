import java.io.*;
import java.util.*;

public class Main {
    private static int N, K;
    private static int[] prefixSum = new int[103];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            prefixSum[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= N - K; i++) {
            int sum = 0;
            for (int j = 0; j < K; j++) {
                sum += prefixSum[i + j];
            }

            if (sum > max) max = sum;
        }
        System.out.println(max);
    }
}