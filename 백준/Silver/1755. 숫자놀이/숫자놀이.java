import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] dict = {8, 5, 4, 9, 1, 7, 6, 3, 2, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int cnt = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (dict[i] >= M && dict[i] <= N) {
                sb.append(dict[i] + " ");

                //엔터
                if (++cnt % 10 == 0) sb.append('\n');
            }

            if (dict[i] * 10 >= M - 10) {
                for (int k = 0; k < 10; k++) {
                    int num = dict[i] * 10 + dict[k];
                    if (num < 10 || num < M || num > N) continue;

                    sb.append(num + " ");
                    if (++cnt % 10 == 0) sb.append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}