class Solution {

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int M = grid.size();
        int N = grid.get(0).size();

        int[][] dist = new int[M][N];  //누적해서 잃은 체력

        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }


        Deque<int[]> queue = new ArrayDeque<>();
        dist[0][0] = grid.get(0).get(0);

        queue.offer(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.pollFirst();

            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {
                int kx = x + dx[k];
                int ky = y + dy[k];

                if (kx < 0 || kx >= M || ky < 0 || ky >= N) {
                    continue;
                }

                int cost = grid.get(kx).get(ky);  //다음 칸에서 잃는 체력
                int next = dist[x][y] + cost;     //다음 칸까지 갔을 때의 잃는 누적 체력

                //체력이 0 이하가 되는 경로 X
                if (next >= health) {
                    continue;
                }

                // 이미 더 적은 체력 손실로 이 칸에 도착한 적 있음
                if (next >= dist[kx][ky]) {
                    continue;
                }

                dist[kx][ky] = next;
                queue.offer(new int[]{kx, ky});
            }
        }

        return dist[M - 1][N - 1] < health;
    }
}