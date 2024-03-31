# 0. import
import sys
input = sys.stdin.readline


# 1. input
N = int(input())
score = list(map(int, input().split()))


# 2. dp
dp = [0 for _ in range(N)]
dp[0] = 0

# 1) 0 ~ i까지의 최댓값 기록
for i in range(1, N):
    # 2) j~i까지의 최댓값 찾기 -> 최댓값이 갱신이 안된다? -> 더이상 범위를 넓힐 필요가 없음
    max_val = 0
    min_val = 10000
    for j in range(i - 1, -1, -1):
        tmp = score[j: i + 1]
        max_tmp = max(tmp)
        min_tmp = min(tmp)
        if max_tmp > max_val or min_tmp < min_val:
            dp[i] = max(max_tmp - min_tmp + dp[j - 1], dp[i])
            max_val = max_tmp
            min_val = min_tmp
        else:
            break

print(dp[-1])