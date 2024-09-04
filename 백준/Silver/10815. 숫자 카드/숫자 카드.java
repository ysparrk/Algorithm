import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        //2. 이분탐색
        M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            sb.append(checkNum(n) + " ");
        }
        System.out.println(sb);
    }

    private static int checkNum(int num) {

        int s = 0;
        int e = N - 1;

        //이분탐색
        while (s <= e) {

            int mid = (s + e) / 2;

            if (num > nums[mid]) {
                s = mid + 1;
            } else if (num < nums[mid]) {
                e = mid - 1;
            } else return 1;
        }
        return 0;
    }
}