# 0. import
import sys
input = sys.stdin.readline

# 1. input
N = int(input())
h_lst = list(map(int, input().split()))
h_lst.sort()

# 2. two pointer
rlt = sys.maxsize
for i in range(N-3):
    for j in range(i+3, N):
        snow = h_lst[i] + h_lst[j]
        left, right = i+1, j-1

        while left < right:
            s = h_lst[left] + h_lst[right]
            if abs(s - snow) < rlt:
                rlt = abs(s - snow)

            if s < snow:
                left += 1
            elif s > snow:
                right -= 1
            else:
                print(0)
                exit()

print(rlt)