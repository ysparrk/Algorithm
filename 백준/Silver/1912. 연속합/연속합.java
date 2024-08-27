import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        prefixSum = new int[N];

        st = new StringTokenizer(br.readLine());
        
        // 누적합 : 지금까지의 합(i-1)까지의 합을 포함 or not
        prefixSum[0] = Integer.parseInt(st.nextToken());
        int rlt = prefixSum[0];
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            //포함하는 경우
            if (prefixSum[i - 1] > 0) {
                prefixSum[i] = prefixSum[i - 1] + num;

            } else {
                prefixSum[i] = num;
            }

            rlt = Math.max(rlt, prefixSum[i]);
        }
        System.out.println(rlt);
    }
}