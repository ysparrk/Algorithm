import sys

INF = sys.maxsize

def solution(n, s, a, b, fares):
    # 1. setting
    dist = [[INF] * n for _ in range(n)]
    
    for i in range(n):
        dist[i][i] = 0
    
    for f in fares:
        x, y, z = f
        dist[x-1][y-1] = z
        dist[y-1][x-1] = z
    
    
    # 2. Floyd_Warshall
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if dist[i][j] > dist[i][k] + dist[k][j]:
                    dist[i][j] = dist[i][k] + dist[k][j]
               
            
    # 3. 최소비용 탐색
    rlt = INF
    for k in range(n):
        rlt = min(rlt, dist[s-1][k] + dist[k][a-1] + dist[k][b-1])
    
    
    return rlt