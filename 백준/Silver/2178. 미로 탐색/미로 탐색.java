import java.io.*;
import java.util.*;

public class Main {
    static int[][] miro;
    static int[][] visited;
    static int N;
    static int M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        //1. input
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        miro = new int[N][M];
        visited = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);

        System.out.println(visited[N - 1][M - 1]);
    }

    
    //2. bfs
    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {x, y});
        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            int temp[] = queue.poll();

            for (int i = 0; i < 4; i++) {
                int kx = temp[0] + dx[i];
                int ky = temp[1] + dy[i];

                if (kx >= 0 && kx < N && ky >= 0 && ky < M) {
                    if (miro[kx][ky] == 1 && visited[kx][ky] == 0) {
                        visited[kx][ky] += visited[temp[0]][temp[1]] + 1;
                        queue.add(new int[]{kx, ky});
                    }
                }
            }
        }
    }
}