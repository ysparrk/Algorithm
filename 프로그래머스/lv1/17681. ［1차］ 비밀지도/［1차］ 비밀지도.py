def solution(n, arr1, arr2):
    answer = ['' for _ in range(n)]
    
    # 1. binary
    for i in range(n):    
        arr1[i] = format(arr1[i], 'b').zfill(n)
        arr2[i] = format(arr2[i], 'b').zfill(n)
    
    
    # 2. answer
    for i in range(n):
        for j in range(n):
            if arr1[i][j] == '1' and arr2[i][j] == '1':
                answer[i] += '#'
            
            elif arr1[i][j] == '0' and arr2[i][j] == '0':
                answer[i] += ' '
            
            else:
                answer[i] += '#'
   

    return answer