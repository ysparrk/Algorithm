# 0. import
from collections import deque


# 1. dfs
def dfs(x, y):

    # x, y에서 시작해서 연속된 #에 visited 표시
    q = deque([(x, y)])
    visited[x][y] = 1
    while q:
        sx, sy = q.popleft()

        for i in range(4):
            kx, ky = sx + d[i][0], sy + d[i][1]

            if 0 <= kx < H and 0 <= ky < W:
                if visited[kx][ky] == 0 and graph[kx][ky] == '#':
                    visited[kx][ky] = 1
                    q.append((kx, ky))


# 2. input
T = int(input())
d = [(0, 1), (0, -1), (1, 0), (-1, 0)]
for _ in range(T):
    H, W = map(int, input().split())

    graph = [list(input()) for _ in range(H)]
    visited = [[0] * W for _ in range(H)]

    cnt = 0
    for i in range(H):
        for j in range(W):
            if visited[i][j] == 0 and graph[i][j] == '#':
                dfs(i, j)
                cnt += 1

    print(cnt)