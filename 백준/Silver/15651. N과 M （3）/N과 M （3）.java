import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] selected;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        selected = new int[M];

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

        for (int i = 1; i <= N; i++) {
            selected[depth] = i;
            recur(depth + 1);
        }
    }
}