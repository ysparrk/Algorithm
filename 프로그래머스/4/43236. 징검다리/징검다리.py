def solution(distance, rocks, n):
    rlt = 0
    
    rocks.sort()
    rocks.append(distance)
    
    left = 0
    right = distance
    
    while left <= right:
        mid = (left + right) // 2
        
        cnt = 0  # 제거한 바위 수
        pre = 0  # 이전 바위 위치
        
        for r in rocks:
            dis = r - pre
            
            if dis < mid:
                cnt += 1
                
                if cnt > n:
                    break
            else:
                pre = r
                
                
        if cnt > n:
            right = mid - 1
            
        else:
            rlt = mid
            left = mid + 1
                  
    return rlt