# 0. import
import heapq
INF = int(1e9)

# 1. input
N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
distance = [INF] * (N+1)

for _ in range(M):
    a, b, c = map(int, input().split())  # 무방향 그래프
    graph[a].append((b, c))
    graph[b].append((a, c))

S, T = map(int, input().split())  # 정점


# 2. 다익스트라
def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))  # 우선순위, 값
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
        
        if distance[now] < dist:  # 이미 방문
            continue

        for i in graph[now]:  # 연결된 모든 노드 탐색
            if dist + i[1] < distance[i[0]]:
                distance[i[0]] = dist + i[1]  # 최소값 바꾸기
                heapq.heappush(q, (dist+i[1], i[0]))  # 힙에 push

dijkstra(S)

print(distance[T])