# 0. import
import sys, heapq
input = sys.stdin.readline
INF = int(1e9)


# 1. input
N, M, A, B, C = map(int, input().split())
graph = [[] for _ in range(N + 1)]

for i in range(M):
    u, v, w = map(int, input().split())
    graph[u].append([v, w])  # node, cost
    graph[v].append([u, w])


# 2. dijkstra
def dijkstra(x):
    distance = [INF for _ in range(N + 1)]
    distance[A] = 0

    # 1) 시작점 push
    q = []
    heapq.heappush(q, [0, A])  # cost, start

    while q:
        cur_cost, cur_node = heapq.heappop(q)

        # 2) 종료조건
        if cur_node == B:
            if distance[cur_node] <= C:
                return distance[cur_node]

        if distance[cur_node] < cur_cost:
            continue

        # 3) 연결된 모든 노드 탐색
        for next_node, next_cost in graph[cur_node]:
            if distance[next_node] > next_cost + cur_cost and next_cost <= x:
                # 제한 비용 이내면 이동
                distance[next_node] = next_cost + cur_cost
                heapq.heappush(q, [next_cost + cur_cost, next_node])

    return False


# 3. binarySearch
left, right = 1, 21
rlt = -1

while left <= right:
    mid = (left + right) // 2

    # 제한 값을 mid로 하고 연결되는지 확인
    if dijkstra(mid):
        rlt = mid
        right = mid - 1
    else:
        left = mid + 1

print(rlt)