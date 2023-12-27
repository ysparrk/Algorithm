# 0. import
from collections import deque
import sys
input = sys.stdin.readline

# 1. input
T = int(input())


# 2. 위상정렬 시 메모이제이션
for _ in range(T):

    N, K = map(int, input().split())  # 건물 개수, 규칙 수
    time = [0] + list(map(int, input().split()))  # 건설 시간

    dp = [0] * (N+1)
    in_degree = [0] * (N+1)
    graph = [[] for _ in range(N + 1)]

    # 1) 진입차수 채우기
    for _ in range(K):
        A, B = map(int, input().split())
        graph[A].append(B)
        in_degree[B] += 1

    W = int(input())  # 건설해야 할 건물


    # 3. 위상정렬
    queue = deque()

    # 1) 진입차수가 0인 노드 큐에 삽입
    for i in range(1, N + 1):
        if in_degree[i] == 0:
            queue.append(i)
            dp[i] = time[i]

    # 2-1) 큐에서 정점을 빼고, 연결된 정점들의 진입차수 배열을 하나 감소
    while queue:

        q = queue.popleft()

        # 2-2) 연결된 노드들 진입차수 감소
        for i in range(len(graph[q])):
            node = graph[q][i]
            in_degree[node] -= 1
            dp[node] = max(dp[node], dp[q] + time[node])

            # 2-3) 진입차수가 0 -> 큐에 넣기
            if in_degree[node] == 0:
                queue.append(node)

        # 3) result
        if in_degree[W] == 0:
            print(dp[W])
            break