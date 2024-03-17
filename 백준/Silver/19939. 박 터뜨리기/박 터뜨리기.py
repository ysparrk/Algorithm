# 1. input
N, K = map(int, input().split())

min_tmp = K * (K + 1) // 2

if N < min_tmp:
    print(-1)
elif (N - min_tmp) % K == 0:
    print(K-1)
else:
    print(K)