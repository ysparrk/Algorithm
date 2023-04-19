def solution(t, p):
    answer = 0
    lt = len(t)
    lp = len(p)

    for i in range(lt-lp+1):
        new = t[i:i+lp]
        
        if int(new) <= int(p):
            answer += 1
        
    return answer