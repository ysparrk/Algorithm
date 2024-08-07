import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 완전탐색
        for (int i = -1000; i <= 1000; i++) {
            for (int j = -1000; j <= 1000; j++) {
                if (i * j == B && i + j == 2 * A) {
                    if (i * -1 > j * -1) System.out.println(-j + " " + -i);
                    else if (i == j) System.out.println(-i);
                    else System.out.println(-i + " " + -j);
                    System.exit(0);
                }
            }
        }
    }
}