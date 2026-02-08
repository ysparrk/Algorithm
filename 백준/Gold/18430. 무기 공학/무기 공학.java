import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, result;
    private static int[][] bmr;
    private static boolean[][] visited;
    private static int dx[][] = {{0, 1}, {-1, 0}, {-1, 0}, {0, 1}};
    private static int dy[][] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N < 2 && M < 2) {
            System.out.println(0);
            return;
        }

        bmr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                bmr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //2. dfs
        result = 0;
        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(int idx, int sum) {
        if (idx == N * M) {
            result = Math.max(result, sum);
            return;
        }

        int kx = idx / M;
        int ky = idx % M;

        if (!visited[kx][ky]) {

            for (int k = 0; k < 4; k++) {
                int x1 = kx + dx[k][0];
                int x2 = kx + dx[k][1];
                int y1 = ky + dy[k][0];
                int y2 = ky + dy[k][1];

                if (isPossible(x1, x2, y1, y2)) {
                    visited[kx][ky] = true;
                    visited[x1][y1] = true;
                    visited[x2][y2] = true;
                    int score = 2 * bmr[kx][ky] + bmr[x1][y1] + bmr[x2][y2];
                    dfs(idx + 1, sum + score);
                    visited[kx][ky] = false;
                    visited[x1][y1] = false;
                    visited[x2][y2] = false;
                }
            }

        }
        dfs(idx + 1, sum);

    }

    private static boolean isPossible(int x1, int x2, int y1, int y2) {
        //부메랑이 가능한지 확인
        if (x1 < 0 || x2 < 0 || x1 >= N || x2 >= N) {
            return false;
        }
        if (y1 < 0 || y2 < 0 || y1 >= M || y2 >= M) {
            return false;
        }

        if (visited[x1][y1] || visited[x2][y2]) {
            return false;
        }

        return true;
    }
}
