import java.io.*;
import java.util.*;

public class Main {

    private static int N, L, R, X, cnt;
    private static int[] level, selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        level = new int[N];
        selected = new int[N];
        cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        //2. 백트래킹
        recur(0, 0, 0, Integer.MAX_VALUE, 0);
        System.out.println(cnt);
    }

    private static void recur(int depth, int selec, int max, int min, int sum) {
        //종료조건
        if (depth == N) {
            if (selec >= 2 && sum >= L && sum <= R && (max - min) >= X) {
                cnt++;
            }
            return;
        }

        //선택 안함
        recur(depth + 1, selec, max, min, sum);

        //선택함
        max = Math.max(max, level[depth]);
        min = Math.min(min, level[depth]);
        sum += level[depth];

        recur(depth + 1, selec + 1, max, min, sum);
    }
}