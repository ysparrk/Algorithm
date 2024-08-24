import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, K, prefixMax;
    private static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        //1. input
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        //2. 누적합
        prefixSum = new int[N + 1];
        prefixMax = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= K; i++) {
            prefixSum[i] += prefixSum[i - 1] + Integer.parseInt(st.nextToken());
        }
        
        prefixMax = prefixSum[K];
        for (int i = K + 1; i <= N; i++) {
            prefixSum[i] += prefixSum[i - 1] + Integer.parseInt(st.nextToken());
            prefixMax = Math.max(prefixMax, prefixSum[i] - prefixSum[i - K]);
        }
        System.out.println(prefixMax);
    }
}