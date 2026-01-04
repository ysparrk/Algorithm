import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static long left = 1, right, answer = 0;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        //이진탐색
        while (left <= right) {
            long mid = (left + right) / 2;

            if (M > getMid(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }

    static int getMid(long mid) {
        int count = 0;
        for (long snack : arr) {
            count += snack / mid;
        }

        return count;
    }
}