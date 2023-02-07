for _ in range(10):
    # 1
    # 초기 설정
    T = int(input())
    arr = [list(map(int, input().split())) for _ in range(100)]   # 100*100 만들기
    i = 99                 # 제일 밑에서 시작
    j = arr[-1].index(2)   # 시작하는 j 값

    # 2
    while i > 0:  # i가 0이 될 때까지
        # 2-1 왼쪽 확인
        if j > 0 and arr[i][j - 1] == 1:  # j가 0보다 큰 경우! 조건을 먼저 넣어야 한다(j가 0일때 out of range뜸)
            arr[i][j] = 0
            j -= 1
            if j == 0:  # 벽에 부딪히면, 인덱스 위로 올리기, 다시 비교할때 j가 0이므로 밖으로 가서 if문 돌때 else로
                i -= 1
        # 2-2 오른쪽 확인
        elif j < 99 and arr[i][j + 1] == 1:
            arr[i][j] = 0
            j += 1
            if j == 99:
                i -= 1
        # 2-3 위로 직진
        else:           # 왼쪽, 오른쪽 전부 길이 없으면 위로 올라가기
            i -= 1
    # 3
    # i가 0일때의 j값을 출력한다.
    print(f'#{T} {j}')