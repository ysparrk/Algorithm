# 1. input
k = int(input())  # 참가한 사람 수
n = int(input())  # 가로 줄

final = list(input())  # 최종 순서
start = sorted(final)  # 시작
ladder = [list(input()) for _ in range(n)]  # 사다리

# 2.
# 위 -> 아래
i = 0
while ladder[i][0] != '?':

    for j in range(k-1):
        if ladder[i][j] == '-':
            start[j], start[j + 1] = start[j + 1], start[j]

    i += 1

# 아래 -> 위
while ladder[n-1][0] != '?':

    for j in range(k-1):
        if ladder[n-1][j] == '-':
            final[j], final[j + 1] = final[j + 1], final[j]

    n -= 1

# 3. answer
ans = []
for i in range(k - 1):
    if start[i] == final[i]:
        ans.append('*')
    else:
        if start[i] == final[i + 1]:
            ans.append('-')
        elif i != 0 and start[i] == final[i - 1]:
            ans.append('*')
        else:
            ans = ['x' for _ in range(k - 1)]
            break

print(*ans, sep='')
