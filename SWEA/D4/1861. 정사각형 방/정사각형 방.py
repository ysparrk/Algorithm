# 1
# bfs 이용, 각 방 번호마다 방문하는 방번호 lst return
def bfs(room, i, j):
    visited = [room[i][j]] # 방문하는 방번호 삽입
    queue = []
    queue.append(i)  # 시작점 큐에 삽입
    queue.append(j)

    # 1-2
    # 상하좌우 탐색 후 해당 방 번호보다 1 크다면 visited에 삽입
    while queue:  # 큐가 비어있지 않을 때까지
        ti, tj = queue.pop(0), queue.pop(0)

        # 탐색
        di = [-1, 1, 0, 0]
        dj = [0, 0, -1, 1]

        for k in range(4):
            i, j = ti + di[k], tj + dj[k]
            if room[i][j] == room[ti][tj] + 1:
                queue.append(i)
                queue.append(j)
                visited.append(room[i][j])

    return visited


# 2
T = int(input())

for tc in range(1, T + 1):
    n = int(input())  # room을 0을로 두른 배열로 받기
    room = [[0]*(n+2)] + [[0] + list(map(int, input().split())) + [0] for _ in range(n)] + [[0]*(n+2)]

    # 2-1
    # 각 방 번호가 key, 이동할 수 있는 방의 개수가 value인 딕셔너리
    rlt = {}
    for i in range(1, n + 1):
        for j in range(1, n + 1):
             rlt[room[i][j]] = len(bfs(room, i, j))

    # 2-2
    # 값 구하기
    r = max(rlt.values())  # value의 max
    ans = [] # max값을 가지는 방 번호 모으는 lst > 최소 출력
    for key, value in rlt.items():
        if value == r:
            ans.append(key)

    print(f'#{tc} {min(ans)} {r}')