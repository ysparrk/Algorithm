# 1
# white > blue > red의 범위 설정
T = int(input())
for tc in range(1, T + 1):
    n, m = map(int, input().split())
    flag = [list(input()) for _ in range(n)]

    ans = n * m  # 최댓값으로 시작
    cnt_white = 0
    for w in range(0, n - 2):          # white
        for j in range(m):
            if flag[w][j] != 'W':
                cnt_white += 1

        cnt_blue = 0
        for b in range(w + 1, n - 1):  # blue
            for j in range(m):
                if flag[b][j] != 'B':
                    cnt_blue += 1

            cnt_red = 0
            for r in range(b + 1, n):      # red
                for j in range(m):
                    if flag[r][j] != 'R':
                        cnt_red += 1

            cnt = cnt_white + cnt_blue + cnt_red
            ans = min(ans, cnt)
    print(f'#{tc} {ans}')