# 1
def bfs(archer):
    global cnt, nt
    c = [i[:] for i in castle]  # deepcopy

    while True:
        enemy = set()
        # 1-1 궁수 3명에 대해 공격할 적 찾기 -> 0으로 바꾸기, count
        for z in range(3):
            e_len = 225          # 최단 거리
            ex, ey = 0, 15       # 적의 좌표
            x, y = nt, archer[z] # 궁수 좌표
            # 1-2 적 찾는 조건
            for i in range(nt-1, -1, -1):
                for j in range(m):
                    distance = abs(x - i) + abs(y - j)
                    if distance <= d and c[i][j] == 1:
                        if distance < e_len:
                            e_len = distance
                            ex, ey = i, j
                        elif distance == e_len and j < ey:  # 같다면 왼쪽으로
                            ex, ey = i, j
            if e_len != 225:
                enemy.add((ex, ey))

        # 1-3 함수 종료조건
        flag = False
        for i in range(nt):
            for j in range(m):
                if castle[i][j] == 1:  # 1이 있다면 flag 바꾸기
                    flag = True
                    break
            if flag:
                break
        if not flag:
            return

        # 1-4
        nt -= 1            # 궁수 위치 바꾸기
        cnt += len(enemy)  # 죽일 적 count
        for e in enemy:    # 적 죽이기
            c[e[0]][e[1]] = 0


# 2-1
n, m, d = map(int, input().split())  # 행, 열, 공격 거리 제한
castle = [list(map(int, input().split())) for _ in range(n)]

# 2-2 궁수의 위치 부분집합 / 순열
sub = []
for i in range(m-2):
    for j in range(i+1, m-1):
        for k in range(j+1, m):
            sub.append([i, j, k])

# 2-3 함수 돌리기
maxCnt = 0
for s in sub:
    cnt = 0
    archer = s  # 부분집합 받기
    nt = n      # 궁수 i값
    bfs(archer)
    if cnt > maxCnt:  # 최대값 갱신
        maxCnt = cnt

print(maxCnt)