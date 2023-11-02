def solution(n, results):
    
    # 1. setting
    graph = [[0]*n for _ in range(n)]
    
    for win, lose in results:
        graph[win-1][lose-1] = 1   # win state
        graph[lose-1][win-1] = -1  # lose state
        
        
    # 2. Floyd_Warshall
    for k in range(n):
        for i in range(n):
            for j in range(n):
                # 1) 순위가 없는 경우 -> 시도X
                if graph[i][k] == 0:
                    continue
                
                # 2) i -> k -> j 순위가 이어질 경우 
                if graph[i][k] == graph[k][j]:
                    graph[i][j] = graph[i][k]
                    graph[j][i] = -graph[i][k]
            
    
    # 3. 그래프에서 0인 값이 하나이면, 순위 정해짐
    answer = 0
    for i in range(n):
        if 0 in graph[i][:i] + graph[i][i+1:]:
            continue
        
        answer += 1

    return answer