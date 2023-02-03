T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    total = []   # 버스가 지나는 정류장을 모두 담는 리스트

    for n in range(N):
        bus = list(map(int, input().split()))

        # 1
        # 슬라이싱해서 필요한 리스트 만들기
        type = bus[0]  # 맨 앞의 버스 타입 슬라이싱
        route = []     # a, b를 통해 route를 담는 리스트
        for i in range(bus[1], bus[-1] + 1):
            route.append(i)

        route_sl = route[1:-1]  # a, b를 제외한 중간 정류장만 담긴 리스트

        # 2 버스가 지나는 정류장을 추출해서 => total로 넣기
        # 1. 일반버스
        if type == 1:
            for i in route:
                total.append(i)

        # 2. 급행버스
        elif type == 2:
            for i in route_sl[1::2]:  # 짝,홀 관계 없이 두번째 값부터 2칸씩 뛰어서 슬라이싱한다.
                total.append(i)
            total.extend([route[0], route[-1]])

        # 3. 광역버스
        elif type == 3:
            if route[0] % 2 == 0:  # 짝수라면
                for i in route_sl:
                    if i % 4 == 0:
                        total.append(i)
                total.extend([route[0], route[-1]])

            elif route[0] % 2 != 0:  # 홀수라면
                for i in route_sl:
                    if i % 3 == 0 and i % 10 != 0:
                        total.append(i)
                total.extend([route[0], route[-1]])

    # 3
    # total 리스트에서 가장 높은 빈도 출력
    cnt = [0] * 1001
    for i in range(len(total)):
        cnt[total[i]] += 1

    print(f'#{tc} {max(cnt)}')