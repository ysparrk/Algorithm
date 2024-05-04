def solution(number, limit, power):

    dp = [0 for _ in range(number + 1)]
    over = set()
    for i in range(1, number + 1):
        for j in range(i, number + 1, i):
            dp[j] += 1
            
            if dp[j] > limit:
                over.add(j)
    
    # 초과 바꾸기
    for o in over:
        dp[o] = power
    
    
    return sum(dp)