def solution(s):
    ls = len(s)
    answer = [0] * ls
    
    for i in range(ls):
        for j in range(i-1, -1, -1):
            if s[i] == s[j]:
                answer[i] = i-j
                break
            else:
                answer[i] = -1            
        else:
            answer[i] = -1
    return answer