def solution(absolutes, signs):
    
    state = {True: 1, False: -1}
 
    answer = 0
    for i in range(len(absolutes)):
        answer += absolutes[i] * state[signs[i]]
        
    return answer