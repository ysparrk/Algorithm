import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] X, prefixSum;
    private static long rlt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        X = new int[N + 1];
        prefixSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            X[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + X[i];
        }

        for (int i = 1; i < N; i++) {
            rlt += (prefixSum[N] - prefixSum[i]) * X[i];
        }

        System.out.println(rlt);
    }
}