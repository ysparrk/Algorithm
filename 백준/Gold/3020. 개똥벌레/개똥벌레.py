# 0. import
import sys
from bisect import bisect_left
input = sys.stdin.readline


# 1. input
N, H = map(int, input().split())  # 길이(짝수), 높이


# 2. 동굴 만들기
low, high = [], []  # 석순, 종유석
for n in range(N):
    l = int(input())

    if n % 2 == 0:
        low.append(l)
    else:
        high.append(l)

low.sort()
high.sort()

# 3. Binary Search
rlt, cnt = N, 1
for i in range(1, H+1):
    l, h = bisect_left(low, i), bisect_left(high, H-i+1)
    total = N - (l+h)

    if total < rlt:
        rlt = total
        cnt = 1
    elif total == rlt:
        cnt += 1

print(rlt, cnt)