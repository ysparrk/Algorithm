T = int(input())

for tc in range(1, T + 1):

    n, m = map(int, input().split()) # 파리, 스프레이 세기
    flies = [list(map(int, input().split())) for _ in range(n)]

    ans = 0
    for i in range(n):
        for j in range(n):
            # 2-1. +
            cnt = flies[i][j]  # 시작좌표 저장
            for di, dj in ((-1, 0), (1, 0), (0, -1), (0, 1)): # 상하좌우
                for mul in range(1, m):
                    ni, nj = i + di * mul, j + dj * mul
                    if 0 <= ni < n and 0 <= nj < n:
                        cnt += flies[ni][nj]

            ans = max(ans, cnt)  # max 갱신

            # 2-2. x
            cnt = flies[i][j]  # 시작좌표 저장
            for di, dj in ((-1, -1), (-1, 1), (1, -1), (1, 1)):  # 대각선
                for mul in range(1, m):
                    ni, nj = i + di * mul, j + dj * mul
                    if 0 <= ni < n and 0 <= nj < n:
                        cnt += flies[ni][nj]

            ans = max(ans, cnt)  # max 갱신

    print(f'#{tc} {ans}')