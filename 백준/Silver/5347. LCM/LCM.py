# 0. import
import sys
input = sys.stdin.readline


# 1. gcd
def gcd(a, b):
    while b:
        mod = b
        b = a % b
        a = mod
    return a


# 2. input
N = int(input())
for _ in range(N):
    A, B = map(int, input().split())

    print(A * B // gcd(A, B))