def solution(e, starts):

    # 1. 약수 모음
    dp = [0] * (e + 1)
    e_sqrt = int(pow(e, 0.5))
    for n in range(1, e_sqrt + 1):
        dp[n * n] += 1
        for i in range(n * (n+1), e + 1, n):
            dp[i] += 2
    
    
    # 2. 결과
    i_min = min(starts) - 1
    s = [x for x in range(e + 1)]
    tmp_max = dp[e]
    tmp_idx = e
    for i in range(e - 1, i_min, -1):
    
        if dp[i] >= tmp_max:
                tmp_max = dp[i]
                tmp_idx = i
        else:
            s[i] = tmp_idx

    
    return [s[x] for x in starts]