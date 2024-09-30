import java.io.*;
import java.util.*;

public class Main {

    private static int N, max, min;
    private static int[] nums, operator;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        operator = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        //2. 백트래킹
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        recur(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void recur(int depth, int calc) {
        if (depth == N) {
            max = Math.max(max, calc);
            min = Math.min(min, calc);
            return;
        }

        for (int i = 0; i < 4; i++) {

            if (operator[i] == 0) continue;

            int tmp = calc;
            operator[i]--;
            switch (i) {
                case 0:
                    calc += nums[depth];
                    break;
                case 1:
                    calc -= nums[depth];
                    break;
                case 2:
                    calc *= nums[depth];
                    break;
                case 3:
                    calc /= nums[depth];
                    break;
            }
            recur(depth + 1, calc);
            operator[i]++;
            calc = tmp;
        }
    }
}