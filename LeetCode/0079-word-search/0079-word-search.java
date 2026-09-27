class Solution {

    private int rows;
    private int cols;
    private boolean[][] visited;
    private String target;
    private char[][] grid;

    public boolean exist(char[][] board, String word) {

        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        this.target = word;
        this.grid = board;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == target.charAt(0)) {
                    visited[i][j] = true;
                    if (dfs(i, j, 0)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
                
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, int charIdx) {
        
        //현재 위치에서 마지막 문자까지 찾았다면 성공
        if (charIdx == target.length() - 1) {
            return true;
        }

        int[] d = {-1, 0, 1, 0, -1};
        
        for (int k = 0; k < 4; k++) {
            int kx = row + d[k];
            int ky = col + d[k + 1];

            //다음 위치가 grid 내에 위치하면
            if (kx >= 0 && ky >=0 && kx < rows && ky < cols) {
                //다음 위치가 방문 X, target과 일치한다면
                if (!visited[kx][ky] && target.charAt(charIdx + 1) == grid[kx][ky]) {
                    visited[kx][ky] = true;
                    if (dfs(kx, ky, charIdx + 1)) {
                        return true;
                    }
                    visited[kx][ky] = false;
                }
            }
        }
        return false;
    }
}