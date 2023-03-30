'''

n명의 직원, 해야할 일 n개 -> 직원들에게 공평하게 일을 하나씩 배분
i번 직원이 j번 일을 하면 성공할 확률이 pi, pj

동철이가 모든 일이 잘 풀리도록 도와주어야 한다.

=> 주어진 일이 모두 성공할 확률의 최댓값을 구하는 프로그램 작성
'''
#
import sys
sys.stdin = open('input.txt')

# 1
# 자리에 놓을 수 있는지 확인
def is_promising(x):
    for i in range(x):
        if row[x] == row[i]:
            return False
    return True

# 2
# n_rook 함수
def n_rook(x):
    global ing
    global workMax
    if x == n:
        workMax = ing  # 마지막까지 곱해졌을 때, workMax 갱신
        return

    else:
        for i in range(n):
            if work[x][i] == 0:
                continue
            else:
                row[x] = i
                if is_promising(x):
                    rlt = work[x][i] * 0.01  # 선택된 확률
                    ing *= rlt  # 곱하기
                    if ing < workMax:  # 현재의 ing가 max보다 벌써 작으면 pass해버린다. pruning
                        ing /= rlt  # return
                        continue
                    else:
                        n_rook(x + 1) # 재귀
                        ing /= rlt  # return

# 3
T = int(input())

for tc in range(1, T + 1):

    n = int(input())
    work = [list(map(int, input().split())) for _ in range(n)]
    row = [0] * n

    ing = 1       # 현재까지의 확률
    workMax = 0   # 최대 값

    n_rook(0)

    print(f'#{tc}{workMax * 100 : .6f}')