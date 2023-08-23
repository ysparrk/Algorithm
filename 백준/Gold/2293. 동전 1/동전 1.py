# 1. input
n, k = map(int, input().split())  # 동전 수
values = [int(input()) for _ in range(n)] # 동전의 가치
values.sort()


# 2. answer
coin = [0 for _ in range(k+1)]
coin[0] = 1

for i in values:
    for j in range(i, k+1):
        coin[j] += coin[j - i]

print(coin[-1])