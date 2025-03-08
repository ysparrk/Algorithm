import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] staffs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        staffs = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            staffs[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(staffs);

        long left = 0;
        long right = (long) staffs[0] * (long) M;

        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += mid / (long) staffs[i];
            }

            if (cnt >= M) right = mid - 1;
            else left = mid + 1;
        }

        System.out.println(left);
    }
}