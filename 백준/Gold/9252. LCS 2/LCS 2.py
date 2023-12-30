# 0. import
import sys
input = sys.stdin.readline


# 1. input
A = list(input())
B = list(input())

nA, nB = len(A), len(B)


# 2. dp
dp = [[''] * (nB+1) for _ in range(nA+1)]

for i in range(1, nA+1):
    for j in range(1, nB+1):
        if A[i-1] == B[j-1]:
            dp[i][j] = dp[i-1][j-1] + A[i-1]
        else:
            if len(dp[i][j-1]) >= len(dp[i-1][j]):
                dp[i][j] = dp[i][j-1]

            else:
                dp[i][j] = dp[i-1][j]


print(len(dp[-1][-1])-1)
print(dp[-1][-1])