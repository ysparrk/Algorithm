# 1. input
N = int(input())
pipe = [list(map(int, input().split())) for _ in range(N)]
dp = [[[0, 0, 0] for _ in range(N)] for _ in range(N)]   # 인덱스 -> 상태 / 가로 세로 대각선 / 현재 상태에서 각 지점으로 갈 수 있는 경우의 수

# 2. 1행 -> 벽이 나오지 않을때까지 1
dp[0][1][0] = 1
for i in range(2, N):
    if pipe[0][i] == 0:
        dp[0][i][0] = 1
    else:
        break


# 3. dp
# 앞 머리 기준
for i in range(1, N):
    for j in range(1, N):
        # 1) 가로세로
        if pipe[i][j] == 0:
            dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2]
            dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2]

        # 2) 대각선
        if pipe[i][j] == 0 and pipe[i-1][j] == 0 and pipe[i][j-1] == 0:
            dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2]

print(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2])