# 1. input
T = int(input())

# 2. dp
dp = [1, 2, 4, 7]
for i in range(T):
    N = int(input())
    
    for j in range(len(dp), N):
        dp.append((dp[-3] + dp[-2] + dp[-1]) % 1000000009)

    print(dp[N - 1])