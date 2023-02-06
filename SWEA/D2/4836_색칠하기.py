'''
10*10 격자에 빨간색, 파란색 색칠
겹쳐진 영역 구한다. / 같은 색인 영역은 겹치지 않는다.
'''

T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    clr1 = set()  # 빨강 set으로 받아서 여러 케이스가 받아질 때 중복값 미리 제거한다.
    clr2 = set()  # 파랑

    # 1
    # 하나씩 input 받기
    for i in range(N):
        x1, y1, x2, y2, c = map(int, input().split())

        # 2
        # 빨강, 파랑 구분해서 set에 넣기
        for x in range(x1, x2 + 1):
            for y in range(y1, y2 + 1):
                if c == 1:
                    clr1.add((x, y))
                elif c == 2:
                    clr2.add((x, y))

    # 3
    # 중복값 찾아서 새로운 set에 넣기/ set의 길이 => 중복된 영역
    new_box = set()
    for i in clr1:  # 빨강에 있는 모든 요소 중에서
        if i in clr2:  # 만약에 i가 파랑에 있다면
            new_box.add(i)  # new_box에 채운다.

    print(f'#{tc} {len(new_box)}')
