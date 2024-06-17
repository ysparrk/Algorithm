def solution(n):

    nums = [0] * (n + 1)
        
    for i in range(2, n + 1):
        for j in range(i, n + 1, i):
            nums[j] += 1
    
    return nums.count(1)