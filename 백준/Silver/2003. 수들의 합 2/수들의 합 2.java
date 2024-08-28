import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //2. 투포인터
        int s = 0;
        int e = 0;
        int cnt = 0;
        int total = nums[0];
        while (e < N) {

            if (total < M) {
                total += nums[++e];
            } else if (total > M) {
                total -= nums[s++];
            } else {
                cnt++;
                total -= nums[s++];
                total += nums[++e];
            }
        }
        System.out.println(cnt);
    }
}