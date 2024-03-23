# 1. input
T = int(input())

for _ in range(T):
    N = int(input())
    arr = list(map(int, input().split()))

    # 2. dp
    dp = [0] * N
    dp[0] = arr[0]

    for i in range(1, N):
        dp[i] = max(dp[i - 1] + arr[i], arr[i])

    print(max(dp))