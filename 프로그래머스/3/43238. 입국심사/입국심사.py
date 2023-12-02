def solution(n, times):
    rlt = 0
    left = 1
    right = max(times) * n
    
            
    while left <= right:
        mid = (left + right) // 2
        
        # mid 시간 동안 얼마나 줄을 설 수 있는지 구하기
        cnt = 0
        for t in times:
            # 심사 받은 수 더하기
            cnt += mid // t
            
            # mid 동안 n명 이상의 심사를 할 수 있다면 반복문 나가기(통과)
            if cnt >= n:
                break

        if cnt >= n:
            rlt = mid
            right = mid - 1
            
        else:
            left = mid + 1
        
    
    return rlt