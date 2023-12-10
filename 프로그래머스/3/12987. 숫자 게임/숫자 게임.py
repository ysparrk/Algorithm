def solution(A, B):    
    A.sort()
    B.sort()
    
    nums = len(A)
    
    i, j, cnt = 0, 0, 0
    while i < nums and j < nums:
        
        if A[i] < B[j]:
            cnt += 1
            i += 1
            j += 1
            
        # 아니면
        else:
            j += 1
            
    
    return cnt