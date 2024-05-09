import sys
from collections import deque


def solution(n, roads, sources, destination):
    
    # 1. init
    graph = [[] for _ in range(n + 1)]
    visited = [-1] * (n + 1)
    
    for u, v in roads:
        graph[u].append(v)
        graph[v].append(u)
        

    # 2. bfs
    # destination에서의 거리
    def bfs():
        q = deque([destination])
        visited[destination] = 0
        
        while q:
            
            now = q.popleft()
            
            for g in graph[now]:
                
                if visited[g] == -1:
                    visited[g] = visited[now] + 1
                    q.append(g)
        
                    
    # 3. result
    bfs()
    
    rlt = []
    for s in sources:
        rlt.append(visited[s])
    
    return rlt