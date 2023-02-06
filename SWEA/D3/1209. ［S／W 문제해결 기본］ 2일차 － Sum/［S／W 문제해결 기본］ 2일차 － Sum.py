for tc in range(1, 11):
    # 1
    # input
    T = int(input())  # tc 번호
    N = 100  # 배열의 크기
    arr = [list(map(int, input().split())) for _ in range(N)] # 2차원 배열 선언
    total_sum = []  # 행, 열, 대각선의 합을 넣을 리스트 선언

    # 2
    # 행의 합 구하기
    for i in range(100):
        sum = 0
        for j in range(100):
            sum += arr[i][j]
        total_sum.append(sum)


    # 열의 합 구하기
    for j in range(100):
        sum = 0
        for i in range(100):
            sum += arr[i][j]
        total_sum.append(sum)


    # 대각선의 합 구하기 -1
    sum = 0
    for i in range(100):

        for j in range(100):
            if i == j:
                sum += arr[i][j]
    total_sum.append(sum)


    # 대각선2 반대 방향
    sum = 0
    for i in range(100):
        for j in range(100):
            if i == 99 - j:
                sum += arr[i][j]
    total_sum.append(sum)

    print(f'#{T} {max(total_sum)}')