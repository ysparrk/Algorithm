import java.io.*;
import java.util.*;

public class Main {

    private static int[] answer, selected;
    private static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = new int[10];
        selected = new int[10];

        for (int i = 0; i < 10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        recur(0);
        System.out.println(cnt);
    }

    private static void recur(int depth) {
        if (depth == 10) {
            int tmp = 0;
            for (int i = 0; i < 10; i++) {
                if (answer[i] == selected[i]) tmp++;
            }
            if (tmp >= 5) cnt++;
            return;
        }

        for (int i = 1; i < 6; i++) {
            if (depth >= 2) {
                if (selected[depth - 1] == i && selected[depth - 2] == i) continue;
            }
            selected[depth] = i;
            recur(depth + 1);
        }
    }
}