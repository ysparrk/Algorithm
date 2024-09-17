import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        recur(1, "");
    }

    private static void recur(int n, String str) {

        //종료 조건
        if (n == N + 1) {
            if (str.length() == 2 * M) {
                System.out.println(str);
            }
            return;
        }

        //선택 or not
        recur(n + 1, str + n + " ");
        recur(n + 1, str);
    }
}