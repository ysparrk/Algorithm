# 0. import
from collections import deque


# 1. input
N = int(input())
color = [list(input()) for _ in range(N)]


# 2. dfs
def dfs(x, y, colorPalette):
    direct = [[1, 0], [-1, 0], [0, 1], [0, -1]]  # 방향

    q = deque([(x, y)])

    while q:
        x, y = q.popleft()

        for k in range(4):
            i, j = x + direct[k][0], y + direct[k][1]

            if 0 <= i < N and 0 <= j < N and not visited[i][j] and color[i][j] in colorPalette:
                visited[i][j] = 1
                q.append((i, j))


# 3. result
# 1) 적록색약X
cnt1 = 0
visited = [[0] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            dfs(i, j, [color[i][j]])
            cnt1 += 1


# 2) 적록색약O
cnt2 = 0
visited = [[0] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if not visited[i][j] and color[i][j] in ["R", "G"]:
            dfs(i, j, ["R", "G"])
            cnt2 += 1

        elif not visited[i][j] and color[i][j] == "B":
            dfs(i, j, ["B"])
            cnt2 += 1

print(cnt1, cnt2)