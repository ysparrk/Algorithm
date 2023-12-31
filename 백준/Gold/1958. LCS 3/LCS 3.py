# 0. import
import sys
sys.stdin.readline

# 1. input
A = list(input())
B = list(input())
C = list(input())

nA, nB, nC = len(A), len(B), len(C)


# 2. dp
dp = [[[0] * (nC+1) for _ in range(nB+1)] for _ in range(nA+1)]

for i in range(1, nA+1):
    for j in range(1, nB+1):
        for k in range(1, nC+1):

            if A[i-1] == B[j-1] == C[k-1]:
                dp[i][j][k] = dp[i-1][j-1][k-1] + 1
            else:
                dp[i][j][k] = max(dp[i-1][j][k], dp[i][j-1][k], dp[i][j][k-1])

print(dp[-1][-1][-1])