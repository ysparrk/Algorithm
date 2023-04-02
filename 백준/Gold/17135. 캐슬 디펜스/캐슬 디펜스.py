from collections import deque

# 1
def bfs(archer):
    global cnt, nt
    c = [i[:] for i in castle]  # deepcopy
    # 1-1
    while True:
        enemy = set()
        for z in range(3):
            e_len = 225  # 최단 거리
            ex, ey = 0, 15 # 적의 좌표
            x, y = nt, archer[z]
            # 1-2 공격할 적 찾기
            for i in range(nt-1, -1, -1):
                for j in range(m):
                    distance = abs(x - i) + abs(y - j)
                    if distance <= d and c[i][j] == 1:  # 한 방향에서 적을 찾으면
                        if distance < e_len:  # 최단거리
                            e_len = distance
                            ex, ey = i, j
                        elif distance == e_len and j < ey:  # 같다면 왼쪽으로
                            ex, ey = i, j
            if e_len != 225:
                enemy.add((ex, ey))

        check = False
        # 종료조건바꾸기
        for i in range(nt):
            for j in range(m):
                if castle[i][j] == 1:
                    check = True
                    break
        # 종료
        if check == False:
            return

        # 궁수의 위치 바꾸기
        nt -= 1
        cnt += len(enemy)
        # 적 죽이기
        for e in enemy:
            c[e[0]][e[1]] = 0



# 2
n, m, d = map(int, input().split())  # 행, 열, 공격 거리 제한

castle = [list(map(int, input().split())) for _ in range(n)]

# 궁수의 위치 부분집합 -> 인덱스 고르기
sub = [] # 궁수의 경우의 수
for i in range(m-2):         # j, k로 선택될 원소를 남김
    for j in range(i+1, m-1):   # k로 선택될 원소를 남김
        for k in range(j+1, m):
            sub.append([i, j, k])

# 함수 돌리기
maxCnt = 0
for s in sub:
    cnt = 0
    archer = deque(s)
    nt = n
    bfs(archer)
    if cnt > maxCnt:
        maxCnt = cnt

print(maxCnt)