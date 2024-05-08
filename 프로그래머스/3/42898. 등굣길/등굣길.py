def solution(m, n, puddles):
    
    dp = [[0 for _ in range(m + 1)] for _ in range(n + 1)]
    
    # 물
    for i, j in puddles:
        dp[j][i] = -1
    
    dp[1][1] = 1
    
    # result
    for i in range(1, n + 1):
        for j in range(1, m + 1):
            
            if dp[i][j] == -1:
                dp[i][j] = 0
            
            else:
                dp[i][j] += (dp[i-1][j] + dp[i][j-1])

                
    return dp[-1][-1] % 1000000007