# 0. input
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

# 1. input
N = int(input())

tree = [[] * (N+1) for _ in range(N+1)]
for _ in range(N-1):
    u, v = map(int, input().split())
    tree[u].append(v)
    tree[v].append(u)

dp = [[0, 0] for _ in range(N+1)]  # dp[i][0] 얼리어답터O 최소, dp[i][1] 얼리어답터X 최소
visited = [0 for _ in range(N+1)]


# 2. dfs
def dfs(node):
    visited[node] = 1
    dp[node][0] = 1
    for i in tree[node]:
        if visited[i] == 0:
            dfs(i)
            dp[node][0] += min(dp[i][0], dp[i][1])
            dp[node][1] += dp[i][0]

dfs(1)
print(min(dp[1][0], dp[1][1]))