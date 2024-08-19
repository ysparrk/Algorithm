import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        boolean[][] board = new boolean[100][100];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            for (int x = X; x < X + 10; x++) {
                for (int y = Y; y < Y + 10; y++) {
                    if (!board[x][y]) cnt++;
                    board[x][y] = true;
                }
            }
        }
        System.out.println(cnt);
    }
}