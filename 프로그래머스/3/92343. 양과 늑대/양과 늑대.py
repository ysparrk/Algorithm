rlt = 0  # 결과

def solution(info, edges):

    # 1. setting
    visited = [0] * len(info)
    
    
    # 2. dfs
    def dfs(sheep, wolf):
        global rlt
        
        # 1) 지속 가능 여부
        if sheep > wolf:
            rlt = max(rlt, sheep)
        else:
            return
        
        # 2) 부모 방문 O, 자식 방문 X -> 언제든 이동 가능
        for u, v in edges:
            if visited[u] and not visited[v]:
                visited[v] = 1
                if info[v] == 0:
                    dfs(sheep + 1, wolf)
                else:
                    dfs(sheep, wolf + 1)
                visited[v] = 0
      
    # 3. result
    visited[0] = 1
    dfs(1, 0)
    
    return rlt