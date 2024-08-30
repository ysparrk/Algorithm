import java.io.*;
import java.util.*;

public class Main {

    private static int N, S;
    private static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        //2. 투포인터
        int s = 0;
        int e = 0;
        long total = nums[0];
        int minLen = N;
        boolean flag = false;
        while (e < N) {

            if (total >= S) {
                minLen = Math.min(minLen, e - s + 1);
                total -= nums[s++];
                flag = true;
            } else {
                total += nums[++e];
            }
        }
        if (flag) System.out.println(minLen);
        else System.out.println(0);
    }
}