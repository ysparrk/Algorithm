def solution(s):
    answer = []
    rlt = ''
    
    for arr in s:        
        stack = ''
        i, cnt = 0, 0
        
        # 1) 110 찾기
        for i in range(len(arr)): 
            if arr[i] == '0' and stack[-2:] == '11':
                # 110 찾으면 제거
                stack = stack[:-2]
                cnt += 1
            else:
                stack += arr[i]
      
        # 2) stack에서 0 찾기 -> 뒤에 110 붙이기
        stack = stack[::-1]
        idx = stack.find('0')
        
        if idx != -1:
            rlt = stack[:idx] + cnt * '011' + stack[idx:]
        
        # 0이 없으면 맨 앞에 넣기
        else:
            rlt = stack + cnt * '011'
        answer.append(rlt[::-1])
    
    return answer