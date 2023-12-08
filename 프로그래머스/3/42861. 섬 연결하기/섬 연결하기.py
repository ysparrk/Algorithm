'''
Kruskal 알고리즘 => 최소 비용으로 모든 노드 연결
간선을 거리가 짧은 순서대로 그래프에 포함시키자
'''
def solution(n, costs):
    answer = 0
    costs.sort(key = lambda x: x[2]) # 비용 기준 오름차순 정렬
    connect = set([costs[0][0]])  # 연결 확인
    
    # Kruskal 
    while len(connect) != n:
        for cost in costs:
            # 1) 사이클 형성되지 않도록
            if cost[0] in connect and cost[1] in connect:
                continue
            
            # 2) 기존 간선과 이어지기
            if cost[0] in connect or cost[1] in connect:
                connect.update([cost[0], cost[1]])
                answer += cost[2]
                break
        
    return answer
