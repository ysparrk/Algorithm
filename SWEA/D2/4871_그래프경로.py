T = int(input())

for tc in range(1, T + 1):
    # 1-1
    # 초기 설정
    V, E = map(int, input().split())  # 정점 V, 간선 E
    data = [list(map(int, input().split())) for _ in range(E)]  # 경로 input
    data = sum(data, [])  # 경로 -> 하나의 list로 만들기
    S, G = map(int, input().split())  # 출발 S, 도착 G
    arr = [[0] * (101) for _ in range(V + 1)]  # 경로 입력 2차원 배열

    # 1-2 간선 입력받기
    for i in range(E):
        n1, n2 = data[i * 2], data[(i * 2) + 1]
        arr[n1][n2] = 1  # 방향 존재, (n1, n2)

    # 2. 탐색
    rlt = []  # 탐색 경로 입력
    visited = [0] * (V + 1)  # 방문 여부 확인 list

    # 2-1
    def dfs(v):
        visited[v] = 1  # 지나친 정점은 1로 표시
        rlt.append(v)
        # 현재 v는 시작정점, 인접한 정점 중 방문을 안한 곳
        for w in range(1, V + 1):
            if arr[v][w] == 1 and visited[w] == 0:
                dfs(w)  # 재귀로 정점 호출

    # 3
    # 시작정점 = S, 경로를 탐색 => 경로 중 G가 있는지 확인
    dfs(S)
    if G in rlt:
        print(f'#{tc} 1')
    else:
        print(f'#{tc} 0')