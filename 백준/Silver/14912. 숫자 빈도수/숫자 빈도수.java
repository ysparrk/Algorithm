import java.io.*;
import java.util.*;

public class Main {
    private static int N, D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            int tmp = i;
            while (tmp > 0) {
                if (tmp % 10 == D) {
                    cnt++;
                }
                tmp /= 10;
            }
        }
        System.out.println(cnt);
    }
}