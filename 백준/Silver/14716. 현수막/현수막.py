# 0. import
import sys
from collections import deque
input = sys.stdin.readline


# 1. bfs
def bfs(x, y):
    q = deque([(x, y)])
    visited[x][y] = 1
    while q:
        nx, ny = q.popleft()

        for i in range(8):
            kx, ky = nx + dx[i], ny + dy[i]
            # 이동 확인
            if 0 <= kx < M and 0 <= ky < N and visited[kx][ky] == 0:
                # 글자면
                if words[kx][ky] == 1:
                    q.append((kx, ky))
                    visited[kx][ky] = 1


# 2. input
M, N = map(int, input().split())
words = [list(map(int, input().split())) for _ in range(M)]
visited = [[0] * N for _ in range(M)]

# 8가지 방향
dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

cnt = 0
for i in range(M):
    for j in range(N):
        if words[i][j] == 1 and visited[i][j] == 0:
            bfs(i, j)
            cnt += 1

print(cnt)