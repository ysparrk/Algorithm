# 0. import
import sys
INF = sys.maxsize
input = sys.stdin.readline


# 1. input
N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
dist = [[INF] * (N + 1) for _ in range(N + 1)]

for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

    # 양방향 길이 있으면 -> 이 거리는 1
    dist[u][v] = 1
    dist[v][u] = 1



# 2. 플로이드 워셜
for i in range(1, N + 1):
    dist[i][i] = 0

for k in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            # i -> k -> j 최단거리 구하기
            if dist[i][j] > dist[i][k] + dist[k][j]:
                dist[i][j] = dist[i][k] + dist[k][j]


# 3. result
node_a, node_b = 0, 0
rlt = INF
# i, j -> 선정된 치킨집
for i in range(1, N + 1):
    for j in range(i + 1, N + 1):
        tmp = 0
        for k in range(1, N + 1):
            tmp += min(dist[i][k], dist[j][k])

            # tmp 값이 rlt보다 커지게 되면 중간에 종료
            if tmp > rlt:
                break

        # k for문 다 돌면 -> i, j 비교하기
        if tmp < rlt:
            rlt = tmp
            node_a, node_b = i, j


print(node_a, node_b, rlt * 2)