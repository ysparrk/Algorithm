from collections import deque

# 1
# bfs 함수
# 토마토에 표시되는 초 > set에 추가(중복제거)
# answer : max(set) - 1 / set에 1만 있다면 -> 이미 다 익은 것
def bfs():
    rlt = set()  # set
    while queue:
        x, y, z = queue.popleft()
        rlt.add(tomato[x][y][z])
        # 3차원
        dx = [-1, 1, 0, 0, 0, 0]
        dy = [0, 0, -1, 1, 0, 0]
        dz = [0, 0, 0, 0, -1, 1]

        for k in range(6):
            sx = x + dx[k]
            sy = y + dy[k]
            sz = z + dz[k]

            if 0 <= sx < h and 0 <= sy < n and 0 <= sz < m and tomato[sx][sy][sz] == 0:
                queue.append([sx, sy, sz])
                tomato[sx][sy][sz] = tomato[x][y][z] + 1  # 1 더해서 익음 표시
                rlt.add(tomato[sx][sy][sz])  # set에 추가
    return rlt

# 2
m, n, h = map(int, input().split())  # 상자 크기, 상자 수
tomato = [[list(map(int, input().split())) for _ in range(n)] for _ in range(h)]  # 3차원 배열

# 2-2
# 익은 토마토 찾기
queue = deque([])
for i in range(h):
    for j in range(n):
        for k in range(m):
            if tomato[i][j][k] == 1:
                queue.append([i, j, k])

# 3. 결과 출력
rlt = bfs()
if len(rlt) == 1:  # 다 익은 경우
    print(0)
else: # 이외의 경우
    tomatoss = sum(sum(tomato, []), []) # 3차원 배열 -> 1차원
    if 0 in tomatoss:  # 0 존재 -> 불가능
        print(-1)
    else:
        print(max(rlt) - 1)