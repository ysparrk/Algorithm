import sys
sys.setrecursionlimit(10**6)

def solution(n, lighthouse):

    # 1. setting
    graph = [[] for _ in range(n + 1)]
    visited = [0 for _ in range(n + 1)]
    dp = [[0, 0] for _ in range(n + 1)]  # [등대 O, 등대X]
    
    for l in lighthouse:
        u, v = l[0], l[1]
        
        graph[u].append(v)
        graph[v].append(u)
    
    
    # 2. dfs
    def dfs(node):
        visited[node] = 1
        dp[node][0] = 1
        
        for i in graph[node]:
            if visited[i] == 0:
                dfs(i)
                dp[node][0] += min(dp[i][0], dp[i][1])  # node가 등대 -> 무조건 등대 X
                dp[node][1] += dp[i][0]  # node가 등대 X -> i가 무조건 등대
                
        
    # 3. result
    dfs(1)
    
    return min(dp[1][0], dp[1][1])