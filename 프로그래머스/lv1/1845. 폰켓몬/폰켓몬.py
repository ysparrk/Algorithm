def solution(nums):
    answer = 0
    n = len(nums)
    rlt = len(set(nums))

    if rlt > n // 2:
        answer = n // 2
    else:
        answer = rlt
    
    
    return answer