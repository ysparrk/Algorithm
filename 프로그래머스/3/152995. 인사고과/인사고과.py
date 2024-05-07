def solution(scores):
    '''
    1. 1) 근무태도 내림차순 2) 동료 평가 오름차순 정렬
    2. 근무태도 + 동료평가 점수 비교    
    '''
    
    W = scores[0]
    W_sum = sum(W)
    rlt = 1
    
    scores.sort(key=lambda x : (-x[0], x[1]))
    tmp = 0  # 동료평가 점수
    
    for s in scores:
        # 1) 인센티브 받지 못하는 경우
        if W[0] < s[0] and W[1] < s[1]:
            return -1
        
        if W_sum < sum(s) and tmp <= s[1]:
            rlt += 1
            tmp = s[1]

    return rlt