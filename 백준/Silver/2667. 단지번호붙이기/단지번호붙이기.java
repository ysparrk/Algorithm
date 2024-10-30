import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[][] board;
    private static boolean[][] visited;
    private static List<Integer> rlt;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //1. input
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];
        rlt = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        //2. dfs : 연결요소의 개수
        StringBuilder sb = new StringBuilder();
        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    total++;
                    rlt.add(dfs(i, j));
                }
            }
        }
        
        //3. result
        Collections.sort(rlt);
        for (int r : rlt) sb.append(r + "\n");

        System.out.println(total);
        System.out.println(sb);
    }

    private static int dfs(int x, int y) {
        int cnt = 1;

        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int kx = dx[k] + x;
            int ky = dy[k] + y;

            if (kx >= 0 && kx < N && ky >= 0 && ky < N) {
                if (visited[kx][ky]) continue;
                if (board[kx][ky] == 0) continue;

                cnt += dfs(kx, ky);
            }
        }
        return cnt;
    }
}