# 0. import
import sys
INF = sys.maxsize

# 1. input
n, m, r = map(int, input().split())  # 지역 개수, 수색범위, 길의 개수
items = [0] + list(map(int, input().split())) # 아이템 수 t
dist = [[INF] * (n + 1) for _ in range(n + 1)]

# 2. dist
for _ in range(r):
    a, b, l = map(int, input().split())  # 지역번호, 길의 길이
    dist[a][b] = l
    dist[b][a] = l

for i in range(n + 1):
    dist[i][i] = 0

# 3. Floyd_Warshall
for k in range(1, n+1):  # 거치는 점
    for i in range(1, n+1):  # 시작 점
        for j in range(1, n+1):  # 끝점
            dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])

# 4. result
rlt = 0
for i in range(1, n+1):
    cnt = 0
    for j in range(1, n+1):
        if dist[i][j] <= m:
            cnt += items[j]

    rlt = max(rlt, cnt)

print(rlt)