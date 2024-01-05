# 1. input
N, K = map(int, input().split())
dp = [[0 for _ in range(N+1)] for _ in range(K+1)]

value = [0]
time = [0]
for _ in range(K):
    v, t = map(int, input().split())
    value.append(v)
    time.append(t)


# 2. dp
for i in range(1, K+1):
    for j in range(1, N+1):
        if time[i] > j:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j-time[i]] + value[i], dp[i-1][j])

print(dp[K][N])
