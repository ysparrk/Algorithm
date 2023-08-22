from collections import deque


# 1. bfs
def bfs(queue):
    melt = deque([]) # 녹일 치즈

    while queue:
        x, y = queue.popleft()

        for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            i, j = x + di, y + dj

            # 1) 공기 -> queue에 추가
            if 0 <= i < n and 0 <= j < m and cheese[i][j] == 0 and visited[i][j] == 0:
                visited[i][j] = 1
                queue.append([i, j])

            # 2) 치즈 -> 공기가 닿는 수 cnt
            elif 0 <= i < n and 0 <= j < m and cheese[i][j] == 1 and visited[i][j] == 0:
                c_visited[i][j] += 1

                if c_visited[i][j] == 2:
                    melt.append([i, j])
                    visited[i][j] = 1

    # 치즈 녹이기
    for x in melt:
        cheese[x[0]][x[1]] = 0

    return melt


# 2. answer
n, m = map(int, input().split())
cheese = [list(map(int, input().split())) for _ in range(n)]

visited = [[0] * m for _ in range(n)]
c_visited = [[0] * m for _ in range(n)]

queue = deque([(0, 0)])
cnt = 0

while True:
    queue = bfs(queue)

    if len(queue) == 0:
        print(cnt)
        break

    else:
        cnt += 1