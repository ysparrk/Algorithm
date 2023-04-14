def solution(N, stages):
    answer = []
    rlt = {}

    for i in range(1, N + 1):
        staged = 0
        fail = 0
        for j in range(len(stages)):
            if stages[j] > i:
                staged += 1  # 도달한 플레이어 수 더하기

            elif stages[j] == i:
                staged += 1
                fail += 1
        
        # 실패율 넣기 -> zero division 방지
        if staged == 0:
            rlt[i] = 0
        else:
            rlt[i] = fail / staged

    # 딕셔너리 정렬
    s = sorted(rlt.values(), reverse=True)
    for i in s:
        for key, value in rlt.items():
            if i == value and key not in answer:
                answer.append(key)

    return answer