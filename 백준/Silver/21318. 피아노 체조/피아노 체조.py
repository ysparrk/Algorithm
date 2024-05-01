# 0. import
import sys
input = sys.stdin.readline

# 1. input
N = int(input())
piano = list(map(int, input().split()))


# 2. 누적합
sum_tmp = [0] * (N + 1)
tmp = 0
for i in range(N - 1):
    if piano[i] > piano[i + 1]:
        tmp += 1
    sum_tmp[i + 1] = tmp


# 3. result
Q = int(input())
for _ in range(Q):
    x, y = map(int, input().split())
    print(sum_tmp[y - 1] - sum_tmp[x - 1])