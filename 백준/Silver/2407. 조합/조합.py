# 1. input
N, M = map(int, input().split())


# 2. dp
arr = [0 for _ in range(N + 1)]
arr[1] = 1

for i in range(2, N + 1):
    arr[i] = arr[i - 1] * i

print(arr[N] // (arr[M] * arr[N - M]))