T = int(input())

for tc in range(1, T + 1):
    # input
    d, a, b, f = map(int, input().split())

    time = d / (a + b)  # 기차가 충돌하기까지 걸린 시간 구하기
    result = round(f * time, 6)  # 걸린 시간동안 파리가 이동한 거리/소수 6번째 자리에서 반올림

    print(f'#{tc} {result}')