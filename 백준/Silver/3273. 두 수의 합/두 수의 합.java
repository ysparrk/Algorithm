import java.io.*;
import java.util.*;

public class Main {

    private static int N, X;
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

        X = Integer.parseInt(br.readLine());

        //2. 투포인터
        Arrays.sort(nums);

        int s = 0;
        int e = N - 1;
        int cnt = 0;
        while (s < e) {
            int tmp = nums[s] + nums[e];

            if (tmp == X) {
                cnt ++;
                s++;
                e--;
            } else if (tmp < X) {
                s++;
            } else {
                e--;
            }
        }
        System.out.println(cnt);
    }
}