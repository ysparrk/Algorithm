# 1. input
n = int(input())
row = list(map(int, input().split()))
ans = [0] * n

# 1번은 row의 인덱스 자리
ans[row[0]] = 1

# 2. result
for i in range(1, n):
    cnt = 0
    for j in range(n):
        if cnt == row[i] and ans[j] == 0:
            ans[j] = i + 1
            break

        # 빈자리 -> 키 큰사람 수 카운트
        elif ans[j] == 0:
            cnt += 1

print(*ans)