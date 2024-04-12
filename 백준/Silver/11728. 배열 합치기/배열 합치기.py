# 0. import
import sys
input = sys.stdin.readline


# 1. input
N, M = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

# 2.
rlt = A + B
rlt.sort()

print(*rlt, sep=" ")
