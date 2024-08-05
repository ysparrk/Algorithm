import java.io.*;
import java.util.*;

public class Main {
    
    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {0, 1};
    private static int[] dy = {1, 0};
    private static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. input
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];
        flag = false;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. dfs
        dfs(0, 0);

        if (flag == true) System.out.println("HaruHaru");
        else System.out.println("Hing");

    }

    private static void dfs(int x, int y) {

        //종료조건
        if (flag) {
            return;
        }

        if (x == N - 1 && y == N - 1) {
            flag = true;
            return;
        }
        
        // dfs
        for (int k = 0; k < 2; k++) {
            int kx = x + dx[k] * map[x][y];
            int ky = y + dy[k] * map[x][y];

            if (kx >= 0 && kx < N && ky >= 0 && ky < N) {
                if (!visited[kx][ky]) {
                    visited[kx][ky] = true;
                    dfs(kx, ky);

                }
            }
        }
    }
}