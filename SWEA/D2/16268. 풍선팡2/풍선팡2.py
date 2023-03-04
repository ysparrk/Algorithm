T = int(input())

for tc in range(1, T + 1):
    # 1. input
    n, m = map(int, input().split())
    balloon = [list(map(int, input().split())) for _ in range(n)]
    
    # 2
    ans = 0
    for i in range(n):
        for j in range(m):
            cnt = balloon[i][j] # 초기값 저장
            for di, dj in ((-1, 0), (1, 0), (0, -1), (0, 1)):  # 상하좌우
                ni, nj = i + di, j + dj
                if 0 <= ni < n and 0 <= nj < m:  # n, m사이에 있어야 한다.
                    cnt += balloon[ni][nj]

            ans = max(ans, cnt)  # ans와 cnt 중 max로 갱신

    print(f'#{tc} {ans}')