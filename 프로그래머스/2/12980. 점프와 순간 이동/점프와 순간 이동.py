def solution(n):
    rlt = 0

    while n > 0:
        
        if n % 2 == 0:
            n //= 2
            
        else:
            n -= 1
            rlt += 1
            
            n //= 2
    

    return rlt