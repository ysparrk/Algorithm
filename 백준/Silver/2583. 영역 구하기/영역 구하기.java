import java.io.*;
import java.util.*;

public class Main {
    static int M, N, K;
    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        //1. input
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[M][N];

        //2. k개의 사각형 visited 표시
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            make_visited(st);
        }

        //3. bfs
        int rlt = 0;
        ArrayList<Integer> board = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    board.add(bfs(i, j));
                    rlt++;
                }
            }
        }

        //3. result
        Collections.sort(board);

        StringBuilder sb = new StringBuilder();
        for (int b : board) {
            sb.append(b).append(" ");
        }

        System.out.println(rlt);
        System.out.println(sb);
    }

    //2. x, y가 주어지면, visited 표시하기
    public static void make_visited(StringTokenizer st) {
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                visited[i][j] = 1;
            }
        }
    }


    //3. x, y지점에서 빈 공간 넓이 구하기
    public static int bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();

        visited[y][x] = 1;
        queue.offer(new int[]{y, x});

        int size = 1;
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int sy = q[0];
            int sx = q[1];

            for (int i = 0; i < 4; i++) {
                int ky = sy + dy[i];
                int kx = sx + dx[i];

                if (0 <= kx && kx < N && 0 <= ky && ky < M && visited[ky][kx] == 0) {
                    if (visited[ky][kx] == 0) {
                        size++;
                        queue.offer(new int[]{ky, kx});
                        visited[ky][kx] = 1;
                    }
                }
            }
        }
        return size;
    }
}