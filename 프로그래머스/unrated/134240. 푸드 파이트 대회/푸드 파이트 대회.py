def solution(food):
    answer = ''
    for i in range(1, len(food)):
        n = food[i] // 2
        answer +=  (str(i) * n)
    
    re_answer = ''.join(reversed(answer))
    answer += '0' + re_answer
        
    return answer