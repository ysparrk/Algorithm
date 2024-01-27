import java.io.*;
import java.util.*;

public class Main {

    static char[][] chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. input
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        chess = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            chess[i] = s.toCharArray();
        }


        //2. 8*8로 잘라내기
        int minCnt = N*M;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                //1) white 인 경우
                minCnt = Math.min(minCnt, cntChess(i, j, true));

                //2) black인 경우
                minCnt = Math.min(minCnt, cntChess(i, j, false));

            }
        }
        System.out.println(minCnt);

    }


    /**
     * x, y에서 시작하는 8*8 체스판에서 count
     * @param isWhite  시작점의 white or not
     * @return cnt
     */
    public static int cntChess(int x, int y, boolean isWhite) {
        int cnt = 0;

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (isWhite && chess[i][j] == 'B') {
                    cnt++;
                } else if (!isWhite && chess[i][j] == 'W') {
                    cnt++;
                }

                isWhite = !isWhite;  //바꾸기
            }
            isWhite = !isWhite;
        }

        return cnt;

    }
}