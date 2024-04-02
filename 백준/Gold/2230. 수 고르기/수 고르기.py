# 0. import
import sys
input = sys.stdin.readline


# 1. input
N, M = map(int, input().split())
nums = [int(input()) for _ in range(N)]
nums.sort()


# 2. two pointer
rlt = int(2e9)
left, right = 0, 0
while left <= right < N:

    tmp = nums[right] - nums[left]
    
    # 1) 종료조건
    if tmp == M:
        rlt = M
        break

    # 2) 차이가 M보다 작으면
    elif tmp < M:
        right += 1

    # 3) 차이가 M보다 크면
    else:
        left += 1
        rlt = min(rlt, tmp)

print(rlt)