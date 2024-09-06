import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;
    private static long[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N];

        long s = 1;
        long e = 0;

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            e = Math.max(e, nums[i]);
        }

        //2. 투포인터
        long rlt = 0;
        while (s <= e) {
            long mid = (s + e) / 2;
            long cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += nums[i] / mid;
            }

            if (cnt >= K) {
                s = mid + 1;
                rlt = mid;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(rlt);
    }
}