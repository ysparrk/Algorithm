T = 10
# 1
# input
for tc in range(1, T + 1):
    N = int(input())  # 덤프 횟수

    box = list(map(int, input().split()))  # input받을 box 리스트
    bsort = [0] * len(box)    # 정렬될 box리스트
    bcount = [0] * (101)      # 0~100 까지 담긴다/ box의 같은 수만큼 카운트 될 리스트

    n = 0
    while n <= N:
        bcount = [0] * (101)          # 0~100 까지 담긴다.
        for i in range(0, len(box)):
            bcount[box[i]] += 1

        # 2. bcount 누적합으로 조정
        for i in range(1, len(bcount)):
            bcount[i] += bcount[i - 1]

        # 3. bsort에 넣어서 정렬하기
        for i in range(len(bsort) - 1, -1, -1):
            bcount[box[i]] -= 1
            bsort[bcount[box[i]]] = box[i]

        # 4
        # n이 덤프횟수가 아닐때 가장 처음과 마지막에 +1, -1 해준다.
        # 마지막 덤프를 할 때 정렬만 되도록
        if n != N:
            bsort[0] += 1
            bsort[-1] -= 1
        box = bsort[:]  # 전체 슬라이싱을 통해 bsort를 box에 넣기
        n += 1  # 횟수 올라가기

        # 5
        # 주어진 덤프 횟수 이내에 평탄화가 완료되면 그때의 최고점과 최저점의 높이 차이 반환
        result = box[-1] - box[0]
        if result <= 1:
            break

    print(f'#{tc} {result}')