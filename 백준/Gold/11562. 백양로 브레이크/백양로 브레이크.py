# 2.
# i지점 -> j지점 까지의 바꾸는 최소 수
def find_road():
    # 플로이드 워셜
    # i -> k -> j
    for k in range(1, N + 1):  # 거치는 점
        for i in range(1, N + 1):  # 시작점
            for j in range(1, N + 1):  # 도착점
                if edge_cnt[i][j] > edge_cnt[i][k] + edge_cnt[k][j]:
                    edge_cnt[i][j] = edge_cnt[i][k] + edge_cnt[k][j]


# 0. import
import sys
INF = sys.maxsize


# 1. input
N, M = map(int, input().split())
edge_cnt = [[INF] * (N + 1) for _ in range(N + 1)]

# 2. 플로이드워셜
for _ in range(M):
    u, v, b = map(int, input().split())  # 1: 길O/내방향X, 0: 길O/내방향O

    edge_cnt[u][v] = 0
    edge_cnt[v][u] = 1

    if b == 1:
        edge_cnt[v][u] = 0

# 자기자신 -> 0
for i in range(1, N + 1):
    edge_cnt[i][i] = 0


# 3. result
find_road()

K = int(input())

for _ in range(K):
    s, e = map(int, input().split())
    print(edge_cnt[s][e])