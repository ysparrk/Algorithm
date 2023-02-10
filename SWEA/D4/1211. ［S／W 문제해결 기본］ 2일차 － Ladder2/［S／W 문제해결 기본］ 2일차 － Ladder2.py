for _ in range(10):
    # 1
    # 초기 설정
    T = int(input())
    arr_input = [list(map(int, input().split())) for _ in range(100)]
    j_idx = {}  # key : j값, value : cnt인 딕셔너리 선언

    # 2
    # i = 99일 때, 값을 1로 가지는 부분에서 위로 올라가며 i=0일때 j좌표를 찾고, 지나가는 경로를 cnt 한다.
    for j in range(100):
        arr = [arr_input[i][:] for i in range(100)]  # slicing 통해 deepcopy**
        i = 99
        cnt = 0
        if arr[-1][j] == 1:
            # 3
            while i > 0:  # i가 0이 될 때까지
                # 3-1. 왼쪽 확인
                if j > 0 and arr[i][j - 1] == 1:  # j가 0보다 큰 경우! 조건을 먼저 넣어야 한다(j가 0일때 out of range뜸)
                    arr[i][j] = 0
                    j -= 1
                    cnt += 1
                    if j == 0:  # 벽에 부딪히면, 인덱스 위로 올리기, 다시 비교할때 j가 0이므로 밖으로 가서 if문 돌때 else로
                        i -= 1
                        cnt += 1
                # 3-2. 오른쪽 확인
                elif j < 99 and arr[i][j + 1] == 1:
                    arr[i][j] = 0
                    j += 1
                    cnt += 1
                    if j == 99:
                        i -= 1
                        cnt += 1
                # 3-3. 위로 직진
                else:         # 왼쪽, 오른쪽 전부 길이 없으면 위로 올라가기
                    i -= 1
                    cnt += 1
            # 4
            # i == 0 일때 j 값 딕셔너리에 넣기
            j_idx[j] = cnt

    # 5
    # 최소인 value값을 갖는 key값 모으기
    # 그 중에서 최대인 key값 출력
    max_idx = []
    for key, value in j_idx.items():
        if value == min(j_idx.values()):
            max_idx.append(key)
    print(f'#{T} {max(max_idx)}')