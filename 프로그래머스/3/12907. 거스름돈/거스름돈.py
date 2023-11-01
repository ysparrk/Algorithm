def solution(n, money):
    money.sort()
    
    # 1. dp
    dp = [0 for _ in range(n+1)]
    dp[0] = 1

    
    for i in money:
        for j in range(i, n+1):
            dp[j] += dp[j-i]
    
    
    return dp[-1]