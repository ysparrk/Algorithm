from collections import deque

def solution(board):
    
    # 1. setting
    rlt = -1
    
    N = len(board)
    M = len(board[0])
    
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    
    visited = [[0] * M for _ in range(N)]
    q = deque()
    
    for i in range(N):
        for j in range(M):
            if board[i][j] == 'R':
                q.append((i, j, 0))
                break
                
                
    # 2. bfs      
    while q:
        x, y, d = q.popleft()
        
        if board[x][y] == 'G':
            rlt = d
            break
        
        for k in range(4):
            dist = 1
            # 한 방향으로 계속 가기
            while True:
                kx, ky = x + dx[k] * dist, y + dy[k] * dist
                # 벽에 부딛힐 경우, 이전 좌표를 큐에 넣기
                if kx < 0 or kx >= N or ky < 0 or ky >= M or board[kx][ky] == 'D':
                    if visited[kx-dx[k]][ky-dy[k]] == 0:
                        visited[kx-dx[k]][ky-dy[k]] = 1
                        q.append((kx-dx[k], ky-dy[k], d + 1))
                    break
                    
                dist += 1
    
    return rlt