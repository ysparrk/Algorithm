import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        nums = new int[N];

        int start = 0;
        int end = N - 1;
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int cnt = 0;
        while (start < end) {
            sum = nums[start] + nums[end];
            if (sum < M) {
                start++;
            } else if (sum == M) {
                start++;
                end--;
                cnt++;
            } else {
                end--;
            }
        }
        System.out.println(cnt);
    }
}