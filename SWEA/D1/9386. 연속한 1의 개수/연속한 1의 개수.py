T = int(input())

# 1
# lst에 받은 숫자열을 하나하나 넣기
for tc in range(1, T + 1):
    N = int(input())
    lst = list(map(int, str(input())))

    # 2
    # lst의 값이 0이 나오면 그때까지의 cnt를 clst에 추가 + 0으로 바꾸기
    # 1이면 1을 더한다.
    cnt = 0
    clst = []
    for i in range(len(lst)):
        if lst[i] == 0:
            clst.append(cnt)
            cnt = 0
        elif lst[i] == 1:
            cnt += 1
    clst.append(cnt)  # 마지막 cnt 값도 더해준다. 그 중 max 값 출력

    print(f'#{tc} {max(clst)}')