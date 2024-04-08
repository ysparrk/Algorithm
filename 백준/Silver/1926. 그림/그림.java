import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] board;
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. result
        int cnt_pic = 0;  // 그림 개수
        int pic_max = 0;  // 그림 최대 넓이
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1 && visited[i][j] == 0) {
                    pic_max = Math.max(pic_max, dfs(i, j));
                    cnt_pic++;
                }
            }
        }

        System.out.println(cnt_pic);
        System.out.println(pic_max);
    }

    // 3. bfs
    public static int dfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = 1;
        queue.offer(new int[] {x, y});

        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int sx = q[0];
            int sy = q[1];

            for (int i = 0; i < 4; i++) {
                int kx = sx + dx[i];
                int ky = sy + dy[i];

                if (0 <= kx && kx < N && 0 <= ky && ky < M) {
                    if (visited[kx][ky] == 0 && board[kx][ky] == 1) {
                        cnt++;
                        queue.offer(new int[]{kx, ky});
                        visited[kx][ky] = 1;
                    }
                }
            }
        }

        return cnt;
    }
}