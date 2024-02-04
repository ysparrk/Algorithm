import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //1. input
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cable = new int[K];

        long max = 0;

        for (int i = 0; i < K; i++) {
            cable[i] = Integer.parseInt(br.readLine());
            if (max < cable[i]) {
                max = cable[i];
            }
        }


        //2. BinarySearch (0 ~ max+1)
        max++;
        long min = 0;
        long mid = 0;
        while (min < max) {
            mid = (min + max) / 2;

            //1) 랜선 개수 확인
            long cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += cable[i] / mid;
            }

            if (cnt < N) {
                max = mid;
            } else {
                min = mid + 1;
            }

        }

        System.out.println(min - 1);
    }
}