def solution(id_list, report, k):
    l = len(id_list)
    arr = [[0] * l for _ in range(l)]
    answer = [0] * l
    
    # 1. 노드 연결
    for i in range(len(report)):
        a, b = report[i].split()
        arr[id_list.index(a)][id_list.index(b)] = 1
    
    # 2. 찾기, k보다 경고 횟수가 크면 answer에 신고자 더하기
    for j in range(l):
        t = 0
        idx = [0] * l
        for i in range(l):
            if arr[i][j] == 1:
                t += arr[i][j]
                idx[i] += 1
        
        if t >= k:
            for m in range(l):
                answer[m] += idx[m]
  
    return answer