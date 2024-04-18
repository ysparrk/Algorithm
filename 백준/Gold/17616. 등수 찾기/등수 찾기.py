# 0. import
import sys
input = sys.stdin.readline

def dfs(X, lst):
    '''
    X의 앞 or 뒤에 있는 학생 수 구하기
    '''
    cnt = 1
    visited[X] = 1

    for next in lst[X]:
        if visited[next] == 0:
            cnt += dfs(next, lst)

    return cnt


# 1. input
N, M, X = map(int, input().split())

front = [[] for _ in range(N + 1)]  # i의 앞에 있는 학생들
back = [[] for _ in range(N + 1)]  # i의 뒤에 있는 학생들
visited = [0 for _ in range(N + 1)]

for _ in range(M):
    A, B = map(int, input().split())

    front[B].append(A)
    back[A].append(B)

# 2. dfs -> result
print(dfs(X, front), N - dfs(X, back) + 1)