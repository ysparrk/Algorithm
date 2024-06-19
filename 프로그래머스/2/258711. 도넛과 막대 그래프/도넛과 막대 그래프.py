def solution(edges):
    
    # 0. setting
    rlt = [0, 0, 0, 0]
    cnt_edges = {}
    
    
    # 1. 
    def count_edges():
        # [out, in] 으로 저장
        for a, b in edges:
            if a not in cnt_edges:
                cnt_edges[a] = [0, 0]
                
            if b not in cnt_edges:
                cnt_edges[b] = [0, 0]
    
            cnt_edges[a][0] += 1
            cnt_edges[b][1] += 1
    
    
    # 2. 
    def get_result():
        '''
        1) 생성된 정점
        - out 2개 이상, in 0
        2) 도넛
        - 모두 out 1, in 1
        - 생성된 정점에 이어진 정점 out 1, in 2  -> 하지만, 8자와 겹칠 수 있음
        3) 막대
        - 하나의 정점이 out 0, in 1 이상
        - 나머지 out 1, in 1
        4) 8자
        - 가운데 정점 out 2 이상, in 2 이상
        - 나머지 out1, in 1
        '''       

        for key, value in cnt_edges.items():
            
            if value[0] >= 2 and value[1] == 0:
                rlt[0] = key
            elif value[0] == 0 and value[1] >= 1:
                rlt[2] += 1
            elif value[0] >= 2 and value[1] >= 2:
                rlt[3] += 1
                
        rlt[1] = cnt_edges[rlt[0]][0] - (rlt[2] + rlt[3])
        
    
    # 3. result
    count_edges()
    get_result()
    
    
    return rlt