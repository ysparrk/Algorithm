import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;

    static int[][] map;
    static int[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        int x = 0, y = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x, y);


        //3. result
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (visited[i][j] == 0 && map[i][j] == 1) {
                    sb.append(-1).append(" ");
                } else {
                    sb.append(visited[i][j]).append(" ");
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    /**
     * 2. bfs
     * visited에 거리 갱신
     */
    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {
            int temp[] = queue.poll();

            for (int i = 0; i < 4; i++) {
                int kx = temp[0] + dx[i];
                int ky = temp[1] + dy[i];

                if (kx >= 0 && kx < N && ky >= 0 && ky < M) {
                    if (map[kx][ky] == 1 && visited[kx][ky] == 0) {
                        visited[kx][ky] += visited[temp[0]][temp[1]] + 1;
                        queue.add(new int[]{kx, ky});
                    }
                }
            }
        }
    }
}