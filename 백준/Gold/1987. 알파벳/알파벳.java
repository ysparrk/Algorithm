import java.io.*;
import java.util.*;

public class Main {

    private static int R, C, rlt;
    private static int[][] board;
    private static boolean[] visitedA;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        visitedA = new boolean[26];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j) - 65;
            }
        }

        visitedA[board[0][0]] = true;
        dfs(0, 0, 1);
        System.out.println(rlt);
    }

    private static void dfs(int x, int y, int cnt) {
        rlt = Math.max(rlt, cnt);

        for (int k = 0; k < 4; k++) {
            int kx = dx[k] + x;
            int ky = dy[k] + y;

            if (kx >= 0 && kx < R && ky >= 0 && ky < C) {
                int nxt = board[kx][ky];
                if (visitedA[nxt]) continue;
                
                visitedA[nxt] = true;
                dfs(kx, ky, cnt + 1);
                visitedA[nxt] = false;
            }
        }
    }
}