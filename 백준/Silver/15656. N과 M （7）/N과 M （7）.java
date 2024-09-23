import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] nums, selected;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        recur(0);
        System.out.println(sb);
    }

    private static void recur(int depth) {

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i] + " ");
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            selected[depth] = nums[i];
            recur(depth + 1);
        }
    }
}