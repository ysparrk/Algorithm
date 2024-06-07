def solution(s):
    
    N = len(s)
    
    if N % 2 == 0:
        return s[N//2 - 1: N//2 + 1]
    
    return s[N//2]