# 0. import
import sys
input = sys.stdin.readline


# 1. input
T = int(input())

for _ in range(T):

    K = int(input())
    file = list(map(int, input().split()))

    # 2. dp
    # i~j까지의 파일을 합쳤을 때 최솟값
    dp = [[0] * (K) for _ in range(K)]

    # 1) i, j 연속 -> 미리 채우기
    for i in range(K - 1):
        dp[i][i + 1] = file[i] + file[i + 1]


    # 2) 맨 밑에서부터 dp 채우기
    for i in range(K - 1, -1, -1):
        for j in range(i + 1, K):

            if dp[i][j] == 0:
                # 플로이드워셜과 비슷 i -> k -> j / i~j까지의 파일 더하기
                dp[i][j] = min([dp[i][k] + dp[k + 1][j] for k in range(i, j)]) + sum(file[i : j + 1])


    # 3. result
    # 1~K 까지 파일을 합치는 최소값
    print(dp[0][K-1])