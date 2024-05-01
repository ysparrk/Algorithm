# 0. import
import sys
input = sys.stdin.readline


# 1. 누적합
def get_SM(A, M):

    # M-1 인덱스 값이 최초 최대
    tmp_sum = sum(A[: M])
    tmp = M * A[M - 1] - tmp_sum
    sm = tmp
    for i in range(M, N):
        tmp_sum += (A[i] - A[i - M]) # 합 갱신
        tmp = M * A[i] - tmp_sum

        sm = min(sm, tmp)

    return sm


# 2. input
T = int(input())

for _ in range(T):
    N, *A = list(map(int, input().split()))
    A.sort()

    # 3. result
    rlt = 0
    for i in range(1, N):
        rlt += get_SM(A, i + 1)

    print(rlt)