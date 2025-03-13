import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, rlt;
    private static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N + 1][M + 1];

        dfs(0);
        System.out.println(rlt);
    }

    private static void dfs(int depth) {
        if (depth == N * M) {
            rlt++;
            return;
        }

        //현재 위치
        int x = depth / M + 1;
        int y = depth % M + 1;

        if (map[x - 1][y] && map[x][y - 1] && map[x - 1][y - 1]) {
            dfs(depth + 1);
        } else {
            //선택X
            dfs(depth + 1);
            map[x][y] = true;

            //선택O
            dfs(depth + 1);
            map[x][y] = false;
        }
    }
}