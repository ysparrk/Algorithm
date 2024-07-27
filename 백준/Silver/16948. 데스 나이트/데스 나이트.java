import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int r2, c2;
    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. input
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        // 2. bfs
        int rlt = bfs(r1, c1);

        System.out.println(rlt);

    }

    private static int bfs(int x, int y) {

        boolean[][] visited = new boolean[N][N];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];
            int nc = now[2];

            for (int k = 0; k < 6; k++) {
                int kx = nx + dx[k];
                int ky = ny + dy[k];

                if (kx >= 0 && kx < N && ky >= 0 && ky < N) {
                    if (!visited[kx][ky]) {
                        if (kx == r2 && ky == c2) {
                            return ++nc;
                        } else {
                            visited[kx][ky] = true;
                            queue.add(new int[]{kx, ky, nc + 1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}