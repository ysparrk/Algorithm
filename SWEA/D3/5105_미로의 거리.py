'''
n*n 크기의 미로에서 출발지, 목적지
최소 몇 개의 칸을 지나면 출발지에서 도착지에 다다를 수 있는가.
0 > 통로, 1 > 벽
마지막줄의 2에서 출발해서, 맨 윗줄의 3에 도착
'''

# 1
# bfs 함수
def bfs(maze, si, sj, n, ai, aj):
    # 1-1
    # visited, queue 생성하고
    # 시작점 queue에 enQueue / 2차원 배열 > si, sj 따로 삽입
    visited = [[0] * n for _ in range(n)]
    queue = []
    queue.append(si)
    queue.append(sj)
    visited[si][sj] = 1  # 방문한 것으로 표시

    # 1-2
    # queue가 비어있지 않으면 0번, 1번째 값을 ti, tj로 pop한다.
    while queue:
        ti, tj = queue.pop(0), queue.pop(0)

        # 1-3 stop!!
        # pop된 ti, tj가 arrive의 i, j 인덱스 값과 같을 때 return
        # return값은 도착지점의 visitied 값에서 -2(출발점, 도착점)
        if ti == ai and tj == aj:
            return visited[ai][aj] - 2

        # 1-4
        # 인접 정점(4방향 탐색) queue에 넣기
        # 벽이 없는 것 주의. error가 난다면 넘어가고 이어지게
        di = [0, -1, 1, 0]
        dj = [-1, 0, 0, 1]

        for k in range(4):
            i = ti + di[k]
            j = tj + dj[k]
            try:
                if maze[i][j] != 1 and visited[i][j] == 0:  # maze에서 값이 1이 아니고, 방문 x
                    queue.append(i)
                    queue.append(j)
                    visited[i][j] = visited[ti][tj] + 1
            except:
                continue

    # 1-5
    # while문에서 return 하지 않으면 0 return
    return 0

# 2
# 설정 및 출력
T = int(input())
for tc in range(1, T + 1):
    n = int(input())

    # 2-2
    # start, arrive 인덱스 구하기
    # 찾을 값의 maze_idx에서의 인덱스를 n으로 나눈 몫과 값은 2차원의 배열에서의 i, j 인덱스 값이 된다.
    maze = [list(map(int, input())) for _ in range(n)]  # str > int로 받기
    maze_idx = sum(maze, [])  # 2차원 배열 > 1차원 list
    si, sj = divmod(maze_idx.index(2), n)
    ai, aj = divmod(maze_idx.index(3), n)

    print(f'#{tc} {bfs(maze, si, sj, n, ai, aj)}')



