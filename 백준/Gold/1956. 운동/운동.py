# 0. import
import sys
INF = sys.maxsize

# 1. input
V, E = map(int, input().split())  # 마을 번호, 도로
load = [[INF] * V for _ in range(V)]  # a, b, c

# 2. Floyd_Warshall
# 최단거리 구하기
for _ in range(E):
    a, b, c = map(int, input().split())
    load[a - 1][b - 1] = c

for k in range(V):
    for i in range(V):
        for j in range(V):
            load[i][j] = min(load[i][j], load[i][k] + load[k][j])

# 3. result
rlt = INF
for i in range(V):
    rlt = min(rlt, load[i][i])

if rlt == INF:
    print(-1)
else:
    print(rlt)