def solution(s):
    answer = 0
    same = 0
    dif = 0
    point = s[0]
    for i in range(len(s)):
               
        if same == dif and same != 0:
            answer += 1
            point = s[i]
            same, dif = 0, 0
        
        # 문자열 비교
        if s[i] == point:
            same += 1
        else:
            dif += 1
    
    answer += 1  # 마지막 문자열 더하기
    return answer