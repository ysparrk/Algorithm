import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int W, H;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    private static int[] dy = {-1, 1, 0, 0, 1, 1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            //1. input
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (W == 0 && H == 0) {
                System.out.println(sb);
                return;
            }

            map = new int[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt + "\n");
        }
    }

    private static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int k = 0; k < 8; k++) {
            int kx = x + dx[k];
            int ky = y + dy[k];

            if (kx >= 0 && kx < H && ky >= 0 && ky < W) {
                if (map[kx][ky] == 1 && !visited[kx][ky]) {
                    dfs(kx, ky);
                }
            }
        }

    }
}