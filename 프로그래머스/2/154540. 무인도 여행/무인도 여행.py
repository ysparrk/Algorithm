from collections import deque

def solution(maps):
    
    # 1. dfs
    def dfs(x, y):
        q = deque([(x, y)])
        visited[x][y] = 1
        tmp = int(maps[x][y])

        while q:
            
            nx, ny = q.popleft()
            
            for k in range(4):
                kx, ky = nx + dx[k], ny + dy[k]
                
                if 0 <= kx < N and 0 <= ky < M:
                    
                    if visited[kx][ky] == 0 and maps[kx][ky] != 'X':
                        visited[kx][ky] = 1
                        q.append((kx, ky))
                        tmp += int(maps[kx][ky])
        
        return tmp
    
    
    # 0. init
    N = len(maps)
    M = len(maps[0])
    visited = [[0 for _ in range(M)] for _ in range(N)]
    
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    
    
    # 2. result
    rlt = []
    for i in range(N):
        for j in range(M):
            if maps[i][j] != 'X' and visited[i][j] == 0:
                rlt.append(dfs(i, j))
                
    if rlt == []:
        return [-1]

    rlt.sort()
                             
    return rlt