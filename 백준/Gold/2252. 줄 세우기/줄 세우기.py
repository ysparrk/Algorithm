# 0. import
from collections import deque


# 1. input
N, M = map(int, input().split())  # 학생, 비교 수


# 2. 진입차수 계산
in_degree = [0] * (N + 1)  # 진입차수
graph = [[] for _ in range(N+1)]  # 그래프

for _ in range(M):
    A, B = map(int, input().split())  # A < B
    graph[A].append(B)
    in_degree[B] += 1


# 3. 위상정렬
def topology_sort():
    rlt = []  # 결과
    queue = deque()

    # 1) 진입차수가 0인 노드 큐에 삽입
    for i in range(1, N+1):

        if in_degree[i] == 0:
            queue.append(i)

    # 2) 큐에서 정점을 빼고, 연결된 정점들의 진입차수 배열을 하나 감소
    while queue:

        q = queue.popleft()
        rlt.append(q)

        # 2-2) 연결된 노드들 진입차수 감소
        for i in range(len(graph[q])):
            node = graph[q][i]
            in_degree[node] -= 1

            # 2-3) 진입차수가 0 -> 큐에 넣기
            if in_degree[node] == 0:
                queue.append(node)

    print(*rlt)

topology_sort()