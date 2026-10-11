import java.util.*;

class Solution {
    
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private int N, M;
    
    
    public int solution(String[] board) {
        int result = 0;
        
        N = board.length;
        M = board[0].length();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i].charAt(j) == 'R') {
                    result = bfs(board, i, j);
                }
            }
        }
        
        return result;
    }
    
    private int bfs (String[] board, int x, int y) {
        
        int[][] visited = new int[N][M];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = 1;
        
        while (!q.isEmpty()) {
            
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            for (int k = 0; k < 4; k++) {
                int kx = curX;
                int ky = curY;
                
                //한 방향으로 이동
                while (0 <= kx && kx < N && 0 <= ky && ky < M && board[kx].charAt(ky) != 'D') {
                    kx += dx[k];
                    ky += dy[k];
                }
                
                //장애물이나 끝 직전 위치
                kx -= dx[k];
                ky -= dy[k];
                
                //목표 지점 확인
                if (board[kx].charAt(ky) == 'G') {
                    return visited[curX][curY];
                }
                

                //기록
                if (visited[kx][ky] == 0) {
                    q.offer(new int[]{kx, ky});
                    visited[kx][ky] = visited[curX][curY] + 1;
                }
            }
            
        }
        
        return -1;
    }
}