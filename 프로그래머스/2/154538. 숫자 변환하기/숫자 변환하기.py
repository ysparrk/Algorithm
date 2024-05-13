from collections import deque


def solution(x, y, n):
    
    q = deque([(x, 0)])
    
    visited = set()
    visited.add(x)
    
    # bfs
    while q:
        
        now, cnt = q.popleft()
        
        if now == y:
            return cnt
        
        # 계산
        for k in (now * 3, now * 2, now + n):
            if k <= y and k not in visited:
                q.append((k, cnt + 1))
                visited.add(k)
    
    return -1