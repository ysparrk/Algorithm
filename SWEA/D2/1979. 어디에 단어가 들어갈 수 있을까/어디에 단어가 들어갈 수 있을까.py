T = int(input())

for tc in range(1, T + 1):
    # 1
    # 초기설정
    n, k = map(int, input().split())
    arr = [list(map(int, input().split())) for _ in range(n)] # n*n 배열
    kcnt = 0  # 자리수 cnt

    # 2-1. 행(가로)
    # 행이 고정된 상태에서 j의 인덱스를 조절하면서 연속으로 1이 몇개 있는지 확인한다.
    # if문을 만족하지 않았을 때 그때까지의 cnt를 확인한다. cnt가 k보다 작거나 크면 x
    # cnt ==k 면 kcnt에 +1 해준다.
    for i in range(n):
        j = 0
        cnt = 0
        while j < n:
            if arr[i][j] == 1:
                cnt += 1
                j += 1
            else:
                if cnt == k:
                    kcnt += 1
                    cnt = 0
                    j += 1
                else:
                    cnt = 0
                    j += 1
        if cnt == k:
            kcnt += 1

    # 2-2. 열(세로)
    for j in range(n):
        i = 0
        cnt = 0
        while i < n:
            if arr[i][j] == 1:
                cnt += 1
                i += 1
            else:
                if cnt == k:
                    kcnt += 1
                    cnt = 0
                    i += 1
                else:
                    cnt = 0
                    i += 1
        if cnt == k:
            kcnt += 1

    print(f'#{tc} {kcnt}')