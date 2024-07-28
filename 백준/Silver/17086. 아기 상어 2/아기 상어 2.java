import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] board;
    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};
    static int maxRlt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. bfs
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    maxRlt = Math.max(maxRlt, bfs(i, j));
                }
            }
        }

        System.out.println(maxRlt);

    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x, y, 0});

        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            for (int k = 0; k < 8; k++) {
                int kx = now[0] + dx[k];
                int ky = now[1] + dy[k];

                if (kx >= 0 && kx < N && ky >= 0 && ky < M) {
                    if (!visited[kx][ky]) {
                        if (board[kx][ky] == 1) {
                            return now[2] + 1;
                        } else {
                            visited[kx][ky] = true;
                            queue.add(new int[]{kx, ky, now[2] + 1});
                        }
                    }
                }
            }
        }
        return N * M;
    }
}