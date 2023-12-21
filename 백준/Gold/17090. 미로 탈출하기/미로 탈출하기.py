# 0. import
import sys
sys.setrecursionlimit(10**6)  # 재귀 최대 깊이 해제

# 1. input
N, M = map(int, input().split())
miro = [list(input()) for _ in range(N)]

direct = {'U': (-1, 0), 'R': (0, 1), 'D': (1, 0), 'L': (0, -1)}
dp = [[-1] * M for _ in range(N)]
cnt = 0


# 2. 이 점이 나가는 경로인지 확인
def check_out(i, j):

    # 1) 나가는 경우
    if i < 0 or i > N-1 or j < 0 or j > M-1:
        return 1

    # 2) 방문 한 경우
    if dp[i][j] != -1:
        return dp[i][j]

    # 3) dp 갱신
    dp[i][j] = 0    # 방문표시
    d = miro[i][j]
    dx, dy = direct[d][0], direct[d][1]
    dp[i][j] = max(dp[i][j], check_out(i+dx, j+dy))  # 나가는 점 표시

    return dp[i][j]


# 3. result
for i in range(N):
    for j in range(M):

        # 1) 방문X -> 나가는 경로에 있는 점인지 확인
        if dp[i][j] == -1:
            if check_out(i, j) != 0:
                cnt += 1

        # 2) 방문O -> 나갈 수 있는 경우
        elif dp[i][j] == 1:
            cnt += 1

print(cnt)