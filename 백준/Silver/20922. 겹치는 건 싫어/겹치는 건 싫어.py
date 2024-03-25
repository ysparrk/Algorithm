# 0. import
import sys
input = sys.stdin.readline


# 1. input
N, K = map(int, input().split())
nums = list(map(int, input().split()))


# 2. two pointer
counter = [0] * (max(nums) + 1)
rlt = 0
left, right = 0, 0
while right < N:
    if counter[nums[right]] < K:
        counter[nums[right]] += 1
        right += 1

    else:
        counter[nums[left]] -= 1
        left += 1

    rlt = max(rlt, right - left)

print(rlt)