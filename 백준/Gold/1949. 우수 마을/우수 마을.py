# 0. import
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)


# 1. input
N = int(input())
population = [0] + list(map(int, input().split()))

tree = [[] for _ in range(N+1)]
for _ in range(N-1):
    u, v = map(int, input().split())
    tree[u].append(v)
    tree[v].append(u)


# 2. dfs
dp = [[0, 0] for _ in range(N+1)]  # dp[i][0] 우수마을O / dp[i][1] 우수마을X
visited = [0 for _ in range(N+1)]

def dfs(node):

    visited[node] = 1  # 방문 표시
    dp[node][0] = population[node]  # node를 우수마을로 선정

    #1) 인접한 노드들
    for i in tree[node]:
        if visited[i] == 0:
            dfs(i)
            dp[node][0] += dp[i][1]  # i가 우수마을이 아닐 경우 인구수 넣어주기
            dp[node][1] += max(dp[i][0], dp[i][1])   # i가 우수마을 or not max값 넣기

dfs(1)
print(max(dp[1][0], dp[1][1]))