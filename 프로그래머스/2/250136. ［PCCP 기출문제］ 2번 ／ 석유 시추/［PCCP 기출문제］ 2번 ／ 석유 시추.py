from collections import deque

def solution(land):
    
    n = len(land)
    m = len(land[0])
    
    visited = [[0] * m for _ in range(n)]
    val_col = [0] * m
    
    # 1.
    # 방문하지 않은 석유 -> dfs -> return되는 value 지나가는 colum에 더하기
    for i in range(n):
        for j in range(m):
            
            # 방문 안한 석유
            if land[i][j] == 1 and visited[i][j] == 0:
                temp, val = dfs(i, j, land, visited, n, m)
                for t in temp:
                    val_col[t] += val
    
                
    return max(val_col)


# 2. dfs
# start 지점에서 dfs -> 총 석유 + 지나가는 col return
def dfs(sx, sy, land, visited, n, m):

    q = deque()
    q.append([sx, sy])
    visited[sx][sy] = 1
    
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    
    val = 1
    col = set()  # 지나가는 column
    col.add(sy)
    while q:
        
        x, y = q.popleft()
        
        for i in range(4):
            kx = x + dx[i]
            ky = y + dy[i]
            
            # 석유인지 확인
            if 0 <= kx < n and 0 <= ky < m:
                if land[kx][ky] == 1 and visited[kx][ky] == 0:
                    val += 1
                    col.add(ky)
                    q.append([kx, ky])
                    visited[kx][ky] = 1
    

    return col, val