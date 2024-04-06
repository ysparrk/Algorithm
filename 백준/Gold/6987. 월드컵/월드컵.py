# 0. import
from itertools import combinations
import sys
input = sys.stdin.readline

# 1. dfs
def backtracking(round):
    '''
    1) 15번의 경기를 다 확인한다
    2) 승, 무, 패가 모두 0이 됐는지 확인한다
    '''
    global flag

    if round == 15:
        for i in range(6):
            for j in range(3):
                if score[i][j] != 0:
                    return
        flag = True
        return

    # x, y 국가가 붙는다 -> 결과는? win, tie, lose 세 경우를 다 따져본다
    x, y = game[round]
    state = [(0, 2), (1, 1), (2, 0)]
    for i, j in ((0, 2), (1, 1), (2, 0)):
        if score[x][i] > 0 and score[y][j] > 0:
            score[x][i] -= 1
            score[y][j] -= 1
            backtracking(round + 1)
            score[x][i] += 1
            score[y][j] += 1


# 2. result
game = list(combinations(range(6), 2))  # 모든 경기의 조합
rlt = []
for _ in range(4):
    data = list(map(int, input().split()))
    score = [data[x:x+3] for x in range(0, 16, 3)]  # 2차원 배열로 변경
    flag = False
    backtracking(0)
    if flag:
        rlt.append(1)
    else:
        rlt.append(0)

print(*rlt)