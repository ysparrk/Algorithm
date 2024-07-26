import java.io.*;
import java.util.*;

public class Main {

    static String[][] board = new String[5][5];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Set<Integer> rltNums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 1. input
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = st.nextToken();
            }
        }

        // 2. dfs
        rltNums = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, board[i][j]);
            }
        }

        System.out.println(rltNums.size());
    }

    private static void dfs(int x, int y, String tmpStr) {

        // 종료조건
        if (tmpStr.length() == 6) {
            rltNums.add(Integer.valueOf(tmpStr));
            return;
        }

        for (int k = 0; k < 4; k++) {
            int kx = x + dx[k];
            int ky = y + dy[k];

            if (kx >= 0 && kx < 5 && ky >= 0 && ky < 5) {
                dfs(kx, ky, tmpStr + board[kx][ky]);
            }
        }
    }
}