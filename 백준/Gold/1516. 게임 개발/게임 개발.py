# 1. input
n = int(input()) # 건물 종류 수
build = [list(map(int, input().split())) for _ in range(n)]

# 2. dp
dp = [0 for x in range(n+1)]
build_com = [0 for x in range(n+1)] # 다 지어짐
complete = 0


# 1) first build possible
for i in range(n):
    if build[i][1] == -1:
        dp[i+1] += build[i][0]  # 시간 더하기
        complete += 1
        build_com[i+1] = 1

while complete < n:
    for i in range(n):
        # 2) pre build del
        j = 1
        while build[i][j] != -1:
            if build_com[build[i][j]]:
                dp[i+1] = max(dp[i+1], dp[build[i][j]])  # 최댓값을 구해야함
                build[i].pop(j)
            else:
                j += 1

        # 3) build complete
        if build[i][1] == -1 and not build_com[i+1]:
            dp[i+1] += build[i][0]
            complete += 1
            build_com[i+1] = 1

print(*dp[1:], sep="\n")