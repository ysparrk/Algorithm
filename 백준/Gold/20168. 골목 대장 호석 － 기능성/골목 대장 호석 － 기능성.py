# 0. import
import sys, heapq
input = sys.stdin.readline
INF = int(1e9)


# 1. input
N, M, A, B, C = map(int, input().split())
graph = [[] for _ in range(N + 1)]
visited = [[0 for _ in range(N + 1)] for _ in range(N + 1)]

for i in range(M):
    u, v, w = map(int, input().split())
    graph[u].append([v, w])  # node, cost
    graph[v].append([u, w])

rlt = INF


# 2. dijkstra
def dijkstra(start):
    global rlt

    # 1) 시작점 push
    q = []
    heapq.heappush(q, [0, 0, start])  #  max, total, node

    while q:
        max_cost, total_cost, now = heapq.heappop(q)

        if total_cost > C:
            continue

        # 2) now와 연결된 모든 노드 탐색
        for node in graph[now]:
            cost = total_cost + node[1]

            # 2-1) C 이상이거나, now -> node를 이미 계산 했으면,
            if cost > C or visited[now][node[0]]:
                continue

            # 2-2) endpoint -> min값 계산
            elif node[0] == B:
                rlt = min(rlt, max(max_cost, node[1]))

            # 2-3) 방문표시, 힙에 node 푸쉬
            visited[now][node[0]] = 1
            heapq.heappush(q, [max(max_cost, node[1]), cost, node[0]])


# 3. result
dijkstra(A)

if rlt == INF:
    print(-1)
else:
    print(rlt)