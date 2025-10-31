class Solution {
    
    private boolean[][] visited;
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};
    private int n, m, answer;
    private char[][] map;
    

    public int solution(String[] storage, String[] requests) {
        
        n = storage.length;
        m = storage[0].length();
        answer = n * m;
        visited = new boolean[n][m];
        map = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            map[i] = storage[i].toCharArray();
        }
        
        for (String request : requests) {
            
            if (request.length() == 1) {
                //지게차(겉만 탐색)
                car(request.charAt(0));
            } else {
                //크레인(안쪽까지 탐색)
                crane(request.charAt(0));
            }
            
        } 
        return answer;
    }
    
    private void crane(char request) {
        //전체를 탐색한다
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == request) {
                    answer--;
                    map[i][j] = 0;
                }
            }
        }
        
    }
    
    
    private void car(char request) {
        //접근 가능한 부분만 가능하다
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i][0]) dfs(i, 0, request);
            if (!visited[i][m-1]) dfs(i, m-1, request);
        }
        
        for (int j = 0; j < m; j++) {
            if (!visited[0][j]) dfs(0, j, request);
            if (!visited[n-1][j]) dfs(n-1, j, request);
        }
    }
    
    private void dfs(int x, int y, char request) {
        visited[x][y] = true;
        
        //제거된 곳 -> 이동
        if (map[x][y] == 0) {
            for (int k = 0; k < 4; k++) {
                int kx = x + dx[k];
                int ky = y + dy[k];
                
                if (kx < 0 || kx >= n || ky < 0 || ky >= m) continue;
                if (!visited[kx][ky]) {
                    dfs(kx, ky, request);
                }
            }
        }
        
        //제거 가능 확인
        if (map[x][y] == request) {
            answer--;
            map[x][y] = 0;
        }
    }
}