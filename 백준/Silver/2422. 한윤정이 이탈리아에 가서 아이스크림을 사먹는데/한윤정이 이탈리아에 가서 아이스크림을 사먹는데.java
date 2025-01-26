import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            check[a][b] = check[b][a] = true;
        }

        int rlt = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (check[i][j]) continue;

                for (int k = j + 1; k <= N; k++) {
                    if (!check[i][k] && !check[j][k]) rlt++;
                }
            }
        }
        System.out.println(rlt);
    }
}