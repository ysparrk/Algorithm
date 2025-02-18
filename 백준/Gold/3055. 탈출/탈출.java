import java.io.*;
import java.util.*;

public class Main {

    private static int R, C;
    private static char[][] board;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        queue = new LinkedList<>();
        
        //1. input
        int sX = -1;
        int sY = -1;
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                switch (board[i][j]) {
                    case '*':
                        queue.offer(new int[]{i, j, 0, '*'});
                        break;
                    case 'S':
                        sX = i;
                        sY = j;
                        break;
                }
            }
        }
        //고슴도치는 마지막에 추가
        queue.offer(new int[]{sX, sY, 0, 'S'});

        //2. bfs
        int rlt = bfs();
        if (rlt == 0) System.out.println("KAKTUS");
        else System.out.println(rlt);
    }

    private static int bfs() {
        //물, 고슴도치 위치를 넣는다.
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];
            int time = now[2];
            int state = now[3];

            for (int k = 0; k < 4; k++) {
                int kx = nx + dx[k];
                int ky = ny + dy[k];
                
                if (kx >= 0 && kx < R && ky >= 0 && ky < C && board[kx][ky] != 'X' && board[kx][ky] != '*') {
                    //현재 위치가
                    switch (state) {
                        case '*':
                            //다음 위치가 빈칸이거나 고슴도치라면 물로 채우기
                            if (board[kx][ky] == '.' || board[kx][ky] == 'S') {
                                queue.offer(new int[]{kx, ky, time + 1, '*'});
                                board[kx][ky] = '*';
                            }
                            break;
                        case 'S':
                            if (board[kx][ky] == 'D') {
                                return time + 1;
                            }
                            //빈칸이라면 이동하기
                            if (board[kx][ky] == '.') {
                                board[kx][ky] = 'S';
                                queue.offer(new int[]{kx, ky, time + 1, 'S'});
                            }
                            break;
                    }
                }
            }
        }
        return 0;
    }
}