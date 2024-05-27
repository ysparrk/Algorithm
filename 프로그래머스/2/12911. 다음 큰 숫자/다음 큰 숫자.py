def solution(n):
    rlt = 0
    cnt = n + 1
    
    while True:
        if bin(cnt).count('1') == bin(n).count('1'):
            return cnt
        cnt += 1
      
    return rlt