def solution(x):
    
    sum = 0
    
    for s in str(x):
        sum += int(s)
        
    if x % sum == 0:
        return True
    
    return False