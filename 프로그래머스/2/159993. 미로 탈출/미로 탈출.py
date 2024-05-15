from collections import deque

def solution(maps):
    
    # 1. setting
    N = len(maps)
    M = len(maps[0])

    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    
    
    # 2. bfs
    def bfs(a, b, target):
        visited = [[0 for _ in range(M)] for _ in range(N)]
        
        visited[a][b] = 1
        q = deque([(a, b)])
        
        while q:
            
            sx, sy = q.popleft()
            
            if maps[sx][sy] == target:
                return visited[sx][sy] - 1
            
            for k in range(4):
                kx, ky = sx + dx[k], sy + dy[k]
                # 범위 내면 이동
                if 0 <= kx < N and 0 <= ky < M and maps[kx][ky] != 'X':
                    if visited[kx][ky] == 0:
                        visited[kx][ky] = visited[sx][sy] + 1
                        q.append((kx, ky))
    
        return -1
        
        
    # 3. result
    sa, sb, la, lb, ea, eb = 0, 0, 0, 0, 0, 0
    for i in range(N):
        for j in range(M):
            if maps[i][j] == 'S':
                sa, sb = i, j
                
            elif maps[i][j] == 'L':
                la, lb = i, j
                
    
    s_to_l = bfs(sa, sb, 'L')
    
    if s_to_l == -1:
        return -1
    
    l_to_e = bfs(la, lb, 'E')
    
    if l_to_e == -1:
        return -1
                

    return s_to_l + l_to_e