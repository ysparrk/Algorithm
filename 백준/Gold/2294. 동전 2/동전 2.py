# 1. input
N, K = map(int, input().split())
values = [int(input()) for _ in range(N)]
values.sort()


# 2. dp
dp = [100001] * (K+1)  # 최대
dp[0] = 0

for v in values:
    for i in range(v, K + 1):
        dp[i] = min(dp[i], dp[i-v] + 1)  # i-v의 위치의 값으로 갱신(최소비교)


# 3. result
if dp[K] == 100001:
    print(-1)
else:
    print(dp[K])