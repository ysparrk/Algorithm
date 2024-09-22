import java.io.*;
import java.util.*;

public class Main {

    private static int N, maxRlt;
    private static int[] nums, selected;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        //1. input
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        selected = new int[N];
        visited = new boolean[N];
        maxRlt = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        //2. 백트래킹
        recur(0);
        System.out.println(maxRlt);
    }

    private static void recur(int depth) {

        //종료조건
        if (depth == N) {
            getMax();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            selected[depth] = nums[i];
            recur(depth + 1);
            visited[i] = false;
        }

    }

    private static void getMax() {

        int tmp = 0;
        for (int i = 0; i < N - 1; i++) {
            tmp += Math.abs(selected[i] - selected[i + 1]);
        }
        maxRlt = Math.max(maxRlt, tmp);
    }
}