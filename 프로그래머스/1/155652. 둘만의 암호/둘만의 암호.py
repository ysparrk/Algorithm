def solution(s, skip, index):
    answer = ''
    alpha = "abcdefghijklmnopqrstuvwxyz"
    
    for i in list(skip):
        alpha = alpha.replace(i, "")
        
    for x in s:
        answer += alpha[(alpha.index(x) + index) % len(alpha)]
    
    return answer