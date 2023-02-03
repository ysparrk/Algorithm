T = int(input())

for tc in range(1, T + 1):

    # 1
    # 버스 노선도 a~b 까지의 수가 담긴 리스트 만들기 + 합치기
    N = int(input())
    route= []
    for n in range(1, N + 1):
        a, b = map(int, input().split())

        for i in range(a, b + 1):
            route.append(i)

    # 2
    # 정류장 번호 리스트 만들기
    P = int(input())  # 정류장 번호
    stop_lst = []
    for i in range(P):
        stop_lst.append(int(input()))

    # 3
    # stop_lst 요소와 같은 값이 route에 있다면, sum을 구해서 result에 넣기
    result = []
    for i in range(len(stop_lst)):
        sum = 0
        for r in route:
            if stop_lst[i] == r:
                sum += 1
            else:
                sum += 0
        result.append(sum)

    print(f'#{tc}', *result)