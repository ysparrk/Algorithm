# 0. import
from collections import deque


def solution(n, wires):
    
    # 1. setting
    graph = [[] for _ in range(n + 1)]
    
    for u, v in wires:
        graph[u].append(v)
        graph[v].append(u)
    
    
    # 2. bfs
    # u - v 길X
    def bfs(u, v, visited):
        
        visited[u] = 1
        visited[v] = 1
        
        q = deque([v])
        cnt = 1
        while q:
            
            now = q.popleft()
            
            for n in graph[now]:
                
                if visited[n] == 0:
                    visited[n] = 1
                    cnt += 1
                    q.append(n)

        return cnt
        
    
    # 3. result
    rlt = n
    for u, v in wires:
        visited = [0] * (n + 1)
        tmp = bfs(u, v, visited)
        
        rlt = min(rlt, abs(n - tmp - tmp))
        
        
    return rlt