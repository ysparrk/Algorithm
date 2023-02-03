# 1
# input
T = int(input())

for tc in range(1, T + 1):
    num = int(input())

    c = [0] * 10  # 6자리 수로부터 각 자리 수를 추출하여 개수를 누적할 리스트/두칸을 더 만들어 놓고 구간 확보하는 것이 낫다.

    # 2
    for i in range(6):
        c[num % 10] += 1   # num을 10으로 나눈 나머지 => 끝자리 /num의 한자리에 해당하는 인덱스 => 그 자리에 1을 추가한다.
        num //=10          # 그 다음 10으로 나눈 몫은 일의 자리가 지워진 상태로 나온다 => for문 돌리면 끝까지.
    # 3
    i = 0
    tri = run = 0
    while i < 10:    # 인덱스 9까지
        if c[i] >= 3:  # triplet 조사한다. 값이 3이상이면 run
            c[i] -= 3      # triplet 조사 후 데이터 삭제 -3
            tri += 1       # tri에 1 더하기
            continue;
        if c[i] >= 1 and c[i+1] >= 1 and c[i+2] >= 1:  # run 조사 후 데이터 삭제
            c[i] -= 1
            c[i+1] -= 1
            c[i+2] -= 1
            run += 1
            continue
        i += 1

    if run + tri == 2:
        print(f'#{tc} 1')
    else:
        print(f'#{tc} 0')