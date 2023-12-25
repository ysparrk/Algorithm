# 1. input
N = int(input())

# 2. dp
rlt = 0
dp = [0] * (N+1)
for i in range(1, N+1):

    graph = list(map(int, input().split()))

    # 1) 선행관계X
    if graph[1] == 0:
        dp[i] += graph[0]

    # 2) 누적
    else:
        n = graph[1]
        for j in range(n):
            if dp[i] < dp[graph[j+2]]:
                dp[i] = dp[graph[j+2]]

        dp[i] += graph[0]

    rlt = max(rlt, dp[i])

print(rlt)