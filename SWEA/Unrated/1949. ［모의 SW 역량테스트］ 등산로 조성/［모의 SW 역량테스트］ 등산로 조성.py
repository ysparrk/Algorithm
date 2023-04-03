# 1
# 봉우리 하나에 대한 maxCnt return
def dfs(x, y):
    global cnt, maxCnt, use_k

    for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
        i, j = x + di, y + dj
        if 0 <= i < n and 0 <= j < n and visited[i][j] == 0:
            # 1) 이동
            if hiking[i][j] < hiking[x][y]:
                visited[i][j] = 1
                cnt += 1
                dfs(i, j)  # 재귀
                cnt -= 1
                visited[i][j] = 0
            # 2) 공사하는 경우
            elif use_k == False and hiking[i][j] - hiking[x][y] < k:
                h = hiking[i][j]
                hiking[i][j] = hiking[x][y] - 1
                visited[i][j] = 1
                cnt += 1
                use_k = True  # 공사 사용 표시
                dfs(i, j)  # 재귀
                use_k = False
                cnt -= 1
                visited[i][j] = 0
                hiking[i][j] = h
    # 1-2 변화 없다면 return
    else:
        if cnt > maxCnt:
            maxCnt = cnt
            return

# 2-1 input
T = int(input())

for tc in range(1, T + 1):
    n, k = map(int, input().split())
    hiking = [list(map(int, input().split())) for _ in range(n)]

    # 2-2 가장 높은 봉우리 찾기
    top = 0
    top_lst = []
    for i in range(n):
        for j in range(n):
            if hiking[i][j] > top:  # top의 변화가 일어나면
                top = hiking[i][j]
                top_lst = []  # 비우고
                top_lst.append([i, j])  # -> 다시 채우기
            elif hiking[i][j] == top:
                top_lst.append([i, j])

    # 2-3 봉우리의 수 만큼 함수 돌리기
    maxCnt = 1
    for i in range(len(top_lst)):
        cnt = 1
        visited = [[0] * n for _ in range(n)]
        visited[top_lst[i][0]][top_lst[i][1]] = 1  # 시작점 visited 표시
        use_k = False                              # 공사 여부
        dfs(top_lst[i][0], top_lst[i][1])          # 함수 시작

    print(f'#{tc} {maxCnt}')