# 0. import
import sys
INF = sys.maxsize

# 1. input
N, K = map(int,input().split())
time = [list(map(int,input().split())) for _ in range(N)]
visited = [0 for _ in range(N)]
visited[K] = 1
rlt = INF

# 2. Floyd_Warshall
for k in range(N):
    for i in range(N):
        for j in range(N):
            time[i][j] = min(time[i][j], time[i][k] + time[k][j])

# 3. Backtracking
def find_min(curr, cost, cnt):
    global rlt
    if N == cnt:
        rlt = min(rlt, cost)
        return
    for i in range(N):
        if visited[i] == 0:
            visited[i] = 1
            find_min(i, cost + time[curr][i], cnt+1)
            visited[i] = 0

find_min(K, 0, 1)

print(rlt)