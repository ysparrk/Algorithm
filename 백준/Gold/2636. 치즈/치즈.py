from collections import deque

def bfs(queue):
    melt = deque([])  # 녹일 치즈
    # air = deque([])  # 공기
    visited = [[0] * m for _ in range(n)]

    while queue:
        x, y = queue.popleft()

        for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            i, j = x + di, y + dj
            if 0 <= i < n and 0 <= j < m and cheese[i][j] == 0 and visited[i][j] == 0:  # 공기라면
                visited[i][j] = 1
                queue.append([i, j])

            elif 0 <= i < n and 0 <= j < m and cheese[i][j] == 1 and visited[i][j] == 0:   #녹을 치즈라면
                visited[i][j] = 1
                melt.append([i, j])

    # 치즈 녹이기
    for l in melt:
        cheese[l[0]][l[1]] = 0

    return melt


# 2
n, m = map(int, input().split()) # 세로, 가로
cheese = [list(map(int, input().split())) for _ in range(n)]


queue = deque([(0, 0)])
c_left = []
cnt = 0
while True:
    queue = bfs(queue)

    if len(queue) == 0:  # 길이가 0이면 끝난 것
        print(cnt)
        print(c_left[-1])
        break
    else:
        cnt += 1  # 더하기.. 시간 추가
        c_left.append(len(queue))