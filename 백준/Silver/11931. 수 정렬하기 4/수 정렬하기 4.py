# 0. import
import sys
input = sys.stdin.readline

# 1. input
T = int(input())

# 2. sort
nums = []
for i in range(T):
    nums.append(int(input()))
nums.sort(reverse=True)

# 3. result
for i in nums:
    print(i)