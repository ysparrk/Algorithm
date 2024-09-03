import java.io.*;
import java.util.*;

public class Main {
   
    private static int K, N;
    private static int[][] weights;
    private static int[] new_weight1, new_weight2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            //1. input
            st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            weights = new int[4][N];

            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < N; k++) {
                    weights[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            new_weight1 = new int[N * N];
            new_weight2 = new int[N * N];

            //2. 투포인터
            makeNewWeight();
            getWeight();
        }
    }

    private static void makeNewWeight() {
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                new_weight1[idx] = weights[0][i] + weights[1][j];
                new_weight2[idx] = weights[2][i] + weights[3][j];
                idx++;
            }
        }
        Arrays.sort(new_weight1);
        Arrays.sort(new_weight2);
    }

    private static void getWeight() {

        int s = 0;
        int e = N * N - 1;
        int rltSum = 0;
        int rltDiffer = Integer.MAX_VALUE;
        while (s < N * N && e >= 0) {
            int total = new_weight1[s] + new_weight2[e];
            int differ = Math.abs(K - total);

            if (differ < rltDiffer) {
                rltSum = total;
                rltDiffer = differ;
            } else if (differ == rltDiffer) {
                if (rltSum > total) rltSum = total;
            }

            //이동
            if (total < K) {
                s++;
            } else if (total > K) {
                e--;
            } else {
                break;
            }
        }
        System.out.println(rltSum);
    }
}