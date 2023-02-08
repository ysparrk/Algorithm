'''
달팽이 = N * N
N 크기의 달팽이 출력
1<= N <= 10

많이 생각해보기

'''

T = int(input())

for tc in range(1, T + 1):
    # 1
    # 초기 설정
    N = int(input())
    arr = [[0]*N for _ in range(N)]  # N*N 빈칸
    di = [0, 1, 0, -1]  # 우하좌상 행
    dj = [1, 0, -1, 0]  # 열
    k = 0   # 방향 값

    i = 0   # 행
    j = -1  # 열 / while문을 처음 들어가게되면 j에 1이 더해지기 때문에 (0,0) 만들기 위함.
    cnt = 1  # count해서 넣을 값

    # 2
    while True:
        if cnt == N * N + 1:  # cnt 값이 N*N을 넘어가면 종료.
            break
        ni = i + di[k]  # 방향 바뀌기 전까지 더하기
        nj = j + dj[k]
        if 0 <= ni < N and 0 <= nj < N and arr[ni][nj] == 0: # [0]인 곳에만 채우기
            arr[ni][nj] = cnt  # 채우기
            cnt += 1
            i, j = ni, nj
        else:         # 방향전환
            k += 1
            k %= 4    # k = 4이면 다시 0으로 돌아가야 한다.
    # 3
    # 출력
    print(f'#{tc}')
    for nums in arr:
        print(*nums, sep=" ")