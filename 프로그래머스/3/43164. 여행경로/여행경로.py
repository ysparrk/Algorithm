# 0. import
from collections import deque
    
# 1. bfs
def solution(tickets):
    rlt = []
    q = deque([("ICN", ["ICN"], [])])  # now, path, visited

    
    while q:
        now, path, visited = q.popleft()
        
        # 종료
        if len(visited) == len(tickets):
            rlt.append(path)
        
        for idx, ticket in enumerate(tickets):
            if ticket[0] == now and not idx in visited:
                q.append((ticket[1], path + [ticket[1]], visited + [idx]))
                
    
    rlt.sort()
    
    return rlt[0]  # 가장 첫번째 paths return