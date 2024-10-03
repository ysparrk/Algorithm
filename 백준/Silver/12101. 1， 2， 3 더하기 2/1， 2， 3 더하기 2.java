import java.io.*;
import java.util.*;

public class Main {

    private static int N, K, turn;
    private static int[] selected;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        selected = new int[N];
        turn = 1;

        recur(0, 0);

        if (sb.length() == 0) System.out.println(-1);
        else System.out.println(sb);

    }

    private static void recur(int depth, int sum) {

        if (sum > N || turn > K) return;

        if (sum == N) {
            if (turn == K) {
                int tmp = 0;
                for (int i = 0; i < N; i++) {
                    sb.append(selected[i]);
                    tmp += selected[i];
                    if (tmp == N) break;
                    sb.append("+");
                }
            }
            turn++;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            selected[depth] = i;
            recur(depth + 1, sum + i);
        }
    }
}