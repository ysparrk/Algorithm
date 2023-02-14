while True:
    try:
        # 1. 인접행렬
        # 1-1 초기설정
        T, E = map(int, input().split())  # 정점 V = 100, 간선 E input
        data = list(map(int, input().split()))  # data input
        arr = [[0] * (100) for _ in range(100)]  # 경로 입력 2차원 배열

        # 1-2 간선 입력받기
        for i in range(E):
            n1, n2 = data[i*2], data[(i*2)+1]
            arr[n1][n2] = 1  # 방향 존재, (n1, n2)

        # 2. 탐색
        visited = [0] * (100)  # 방문 여부 확인 list

        # 2-1
        def dfs(v):
            visited[v] = 1  # 지나친 정점은 1로 표시
            # 현재 v는 시작정점, 인접한 정점 중 방문을 안한 곳
            for w in range(1, 100):
                if arr[v][w] == 1 and visited[w] == 0:
                    dfs(w)  # 재귀로 정점 호출

        # 3
        # 시작정점 = 0, visited의 마지막 값이 1로 채워졌다면, 경로 99를 지나간 것.
        dfs(0)
        if visited[-1] == 1:
            print(f'#{T} 1')
        else:
            print(f'#{T} 0')

    except:
        break