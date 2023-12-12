# 0. import
from heapq import heappush, heappop
import sys

INF = sys.maxsize


# 1. dijkstra
def dijkstra(n, graph, start):
    dist = [INF for _ in range(n)]
    dist[start] = 0

    queue = []
    heappush(queue, [dist[start], start])

    while queue:
        cur_dist, cur_node = heappop(queue)
        if dist[cur_node] >= cur_dist:
            for i in range(n):
                temp = cur_dist + graph[cur_node][i]
                if temp < dist[i]:
                    dist[i] = temp
                    heappush(queue, [temp, i])
    return dist


# 2.
def solution(n, s, a, b, fares):
    # 2-1) setting
    graph = [[INF] * n for _ in range(n)]

    for f in fares:
        x, y, z = f
        graph[x - 1][y - 1] = z
        graph[y - 1][x - 1] = z


    # 2-2) 모든 노드에 대해 다익스트라 수행
    find_min_dist = []
    for i in range(n):
        find_min_dist.append(dijkstra(n, graph, i))

    # 2-3) 최소비용 탐색
    rlt = INF
    for k in range(n):
        rlt = min(rlt, find_min_dist[s - 1][k] + find_min_dist[k][a - 1] + find_min_dist[k][b - 1])

    return rlt