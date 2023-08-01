def solution(participant, completion):
    
    dict = {}
    sum = 0
    
    # 해시 값으로 동명이인 덮어쓰기
    for part in participant:
        dict[hash(part)] = part
        sum += hash(part)
    
    # 완주한 참가자 해시값 빼기 -> 남은 값을 해시값으로 가지고 있는 참가자가 '완주하지 못한 선수'
    for comp in completion:
        sum -= hash(comp)
        
    return dict[sum]