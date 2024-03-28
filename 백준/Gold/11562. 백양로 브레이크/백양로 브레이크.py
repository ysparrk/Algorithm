# 2.
# i지점 -> j지점 까지의 바꾸는 최소 수
def find_road():

    edge_cnt = [[INF] * (N + 1) for _ in range(N + 1)]

    # 1)
    # 본인 지점 0으로 바꾸기, 길이 있으면 0으로 만들기
    # 길은 있는데 양방향은 아니면 -> 일단 바꾸기
    for i in range(1, N + 1):
        for j in range(1, N + 1):

            if i == j:
                edge_cnt[i][j] = 0

            elif graph[i][j] == 2:
                edge_cnt[i][j] = 0

            elif graph[i][j] == 1:
                edge_cnt[i][j] = 1

    # 2) 플로이드 워셜
    # i -> k -> j
    for k in range(1, N + 1):  # 거치는 점
        for i in range(1, N + 1):  # 시작점
            for j in range(1, N + 1):  # 도착점
                if edge_cnt[i][j] > edge_cnt[i][k] + edge_cnt[k][j]:
                    edge_cnt[i][j] = edge_cnt[i][k] + edge_cnt[k][j]

    return edge_cnt


# 0. import
import sys
INF = sys.maxsize


# 1. input
N, M = map(int, input().split())
graph = [[0] * (N + 1) for _ in range(N + 1)]


for _ in range(M):
    u, v, b = map(int, input().split())  # 1: 들어오는 길, 2: 나가는 길

    graph[u][v] = 2
    graph[v][u] = 1
    if b == 1:
        graph[v][u] = 2


# 3. result
rlt = find_road()

K = int(input())

for _ in range(K):
    s, e = map(int, input().split())
    print(rlt[s][e])