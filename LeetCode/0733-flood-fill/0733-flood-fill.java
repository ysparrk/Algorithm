class Solution {

    int[][] visited;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int N, M;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        N = image.length;
        M = image[0].length;

        int start = image[sr][sc];
        if (start == color) {
            return image;
        }

        visited = new int[N][M];
        dfs(image, sr, sc, start, color);

        return image;
    }

    private void dfs(int[][] image, int r, int c, int start, int target) {
        visited[r][c] = 1;
        image[r][c] = target;
        for (int k = 0; k < 4; k++) {
            int kx = r + dx[k];
            int ky = c + dy[k];

            if (0 <= kx && kx < N && 0 <= ky && ky < M) {
                if (visited[kx][ky] == 0 && image[kx][ky] == start) {
                    dfs(image, kx, ky, start, target);
                }
            }
        }
    }
}