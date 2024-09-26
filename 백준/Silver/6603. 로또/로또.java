import java.io.*;
import java.util.*;

public class Main {

    private static int k;
    private static int[] S, selected;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1. input
        while (true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            S = new int[k];
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            
            //2. 백트래킹
            selected = new int[6];
            recur(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void recur(int depth, int idx) {
        //종료조건
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(selected[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < k; i++) {
            selected[depth] = S[i];
            recur(depth + 1, i + 1);
        }
    }
}