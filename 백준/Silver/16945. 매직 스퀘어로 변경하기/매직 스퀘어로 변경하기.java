import java.io.*;
import java.util.*;

public class Main {

    private static int rlt;
    private static int[][] board;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[3][3];
        visited = new boolean[10];
        rlt = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0);
        System.out.println(rlt);
    }

    private static void recur(int depth, int cost) {
        if (depth == 9) {
            if (isMagicSquare()) {
                rlt = Math.min(rlt, cost);
            }
            return;
        }

        int x = depth / 3;  //0, 0, 0, 1, 1, 1, 2, 2, 2
        int y = depth % 3;  //0, 1, 2, 0, 1, 2, 0, 1, 2

        for (int i = 1; i <= 9; i++) {
            if (!visited[i]) {
                int tmp = board[x][y];
                board[x][y] = i;
                visited[i] = true;
                recur(depth + 1, cost + Math.abs(tmp - i));
                visited[i] = false;
                board[x][y] = tmp;
            }
        }
    }

    private static boolean isMagicSquare() {
        //매직스퀘어인지 확인
        for (int i = 0; i < 3; i++) {
            int row = board[i][0] + board[i][1] + board[i][2];
            int col = board[0][i] + board[1][i] + board[2][i];

            if (row != 15 || col != 15) return false;
        }

        int dia1 = board[0][0] + board[1][1] + board[2][2];
        int dia2 = board[2][0] + board[1][1] + board[0][2];

        if (dia1 != 15 || dia2 != 15) return false;

        return true;
    }
}