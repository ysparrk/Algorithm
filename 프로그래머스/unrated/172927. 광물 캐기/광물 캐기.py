def solution(picks, minerals):
    answer = 0
    n = sum(picks) # 총 곡괭이 수
    sub = []
    
    # 1. minerals 5개씩 잘라서 -> 곡괭이 별로 발생하는 피로도 저장
    for x in range(n):  # n번
        d, i, s = 0, 0, 0
        try:
            for y in range(x*5, x*5+5):
                if minerals[y] == 'diamond':
                    d += 1
                elif minerals[y] == 'iron':
                    i += 1
                else:
                    s += 1
        except:
            sub.append([d+i+s, d*5+i+s, d*25+i*5+s])  # index error 발생하면, 저장하고 종료
            break
        
        sub.append([d+i+s, d*5+i+s, d*25+i*5+s])

            
    # 2. 제일 피로도가 높은 순서대로 정렬
    # bubble sort : dia가 제일 큰 순서 > iron > stone
    for i in range(len(sub)-1, 0, -1):
        for j in range(i):
            if sub[j][0] < sub[j+1][0] or sub[j][1] < sub[j+1][1] or sub[j][2] < sub[j+1][2]:
                sub[j], sub[j+1] = sub[j+1], sub[j]
                
    # 3. 곡괭이 정하기 -> dia 먼저 사용
    for i in range(len(sub)):
        if picks[0]:
            answer += sub[i][0]
            picks[0] -= 1
        elif picks[1]:
            answer += sub[i][1]
            picks[1] -= 1
        elif picks[2]:
            answer += sub[i][2]
            picks[2] -= 1
        
    return answer