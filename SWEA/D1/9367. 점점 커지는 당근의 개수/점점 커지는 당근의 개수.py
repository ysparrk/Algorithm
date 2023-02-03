T = int(input())
# 1
# input
for tc in range(1, T + 1):
    N = int(input())  # 당근 개수
    carrot = list(map(int, input().split()))  # 당근의 크기

    # 2
    # carrot의 마지막 직전까지 for문 돌린다. 바로 뒤의 값보다 작다면, cnt에 1 더하기
    # 자기 자신도 포함하므로 cnt는 1로 시작한다.
    cnt = 1
    clst = []
    for i in range(len(carrot) - 1):
        if carrot[i] < carrot[i + 1]:
            cnt += 1
        else:
            clst.append(cnt)
            cnt = 1
    clst.append(cnt)      # 마지막 cnt 값 clst에 추가

    print(f'#{tc} {max(clst)}')