# 1. input
A = list(input())
B = list(input())

nA, nB = len(A), len(B)


# 2. dp
dp = [[0] * (nB+1) for _ in range(nA+1)]

for i in range(1, nA+1):
    for j in range(1, nB+1):
        if A[i-1] == B[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i][j-1], dp[i-1][j])


print(dp[-1][-1])