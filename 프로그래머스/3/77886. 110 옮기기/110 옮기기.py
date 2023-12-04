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
        idx = stack.rfind('0')
        if idx != -1:
            rlt = stack[:idx+1] + cnt * '110' + stack[idx+1:]
        
        # 0이 없으면 맨 앞에 넣기
        else:
            rlt = cnt * '110' + stack
        answer.append(rlt)
    
    return answer