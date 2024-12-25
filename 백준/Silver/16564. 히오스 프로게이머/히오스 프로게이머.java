import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;
    private static int[] X;
    private static long rlt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        X = new int[N];

        long max = Integer.MAX_VALUE;
        long min = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            X[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, X[i]);  //최솟값
        }

        //이진탐색
        while (min <= max) {
            //매개변수 mid
            long mid = (min + max) / 2;

            //mid값으로 적용했을때, 성립하는지 확인
            long tmp = 0;
            for (int i = 0; i < N; i++) {
                if (mid > X[i]) {
                    tmp += mid - X[i];
                }
            }

            if (tmp <= K) {
                rlt = Math.max(rlt, mid);
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(rlt);
    }
}