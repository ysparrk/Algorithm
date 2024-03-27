# 0. import
from collections import deque
import sys
input = sys.stdin.readline
INF = sys.maxsize


# 2. bfs
def bfs(q, state):
    '''
    1. state -> 불/이동
    2. 빈공간에 불/이동
    '''
    global W, H

    while q:
        x, y, time = q.popleft()

        # 이동
        for i in range(4):
            kx, ky = x + dx[i], y + dy[i]

            if 0 <= kx < H and 0 <= ky < W:
                if build[kx][ky] == '.' or build[kx][ky] == '@':
                    if visited[kx][ky] > time + 1:
                        visited[kx][ky] = time + 1
                        q.append((kx, ky, time + 1))

            # 범위를 벗어나면, 스탑
            elif state == 'b':
                print(time + 1)
                return

    if state == 'b':
        print("IMPOSSIBLE")



# 1. input
T = int(input())

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

# 3. result
for _ in range(T):
    W, H = map(int, input().split())
    build = [list(input()) for _ in range(H)]
    visited = [[INF] * W for _ in range(H)]
    q = deque([])  # 이동 지점
    fq = deque([]) # 불

    # 3-1) 시작점 찾기
    for i in range(H):
        for j in range(W):
            if build[i][j] == '@':
                q.append((i, j, 0))
                visited[i][j] = 1

            elif build[i][j] == '*':
                fq.append((i, j, 0))
                visited[i][j] = 0

    # 3-2) bfs
    bfs(fq, 'f')
    bfs(q, 'b')
