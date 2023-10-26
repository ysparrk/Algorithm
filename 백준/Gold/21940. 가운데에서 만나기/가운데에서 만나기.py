# 0. import
import sys
INF = sys.maxsize
input = sys.stdin.readline

# 1. input
N, M = map(int, input().split())  # 도시 개수, 도로 개수
graph = [[INF] * (N+1) for _ in range(N+1)]

for _ in range(M):
    a, b, t = map(int, input().split())
    graph[a][b] = t

for i in range(N+1):
    graph[i][i] = 0


# 2. Floyd_Warshall
for k in range(1, N+1):
    for i in range(1, N+1):
        for j in range(1, N+1):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])


# 3. 최대의 최소 거리 구하기
K = int(input())
city = list(map(int, input().split()))

city_min = INF
rlt = []
for i in range(1, N+1):
    dis_max = 0
    for c in city:
        dis_max = max(dis_max, graph[c][i] + graph[i][c])
    
    # 최소 도시 구하기
    if city_min == dis_max:
        rlt.append(i)
    elif city_min > dis_max:
        rlt = []
        rlt.append(i)
        city_min = dis_max

print(*rlt)