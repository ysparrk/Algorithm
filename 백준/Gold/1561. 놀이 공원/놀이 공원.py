# 0. import
import sys
input = sys.stdin.readline


# 1.
# 0 ~ t분까지 놀이기구를 타는 사람의 수
def numForT(t, time):
    cnt = 0
    for i in time:
        cnt += t // i

    return cnt


# 3.
# m분에 남은 사람(k명) 중 마지막 아이가 타는 놀이기구 번호 출력
def findLast(k, m, time):
    for idx, t in enumerate(time):
        if m % t == 0:
            k -= 1

            if k == 0:
                return idx + 1


# 4. input + result
N, M = map(int, input().split())  # 아이들 수, 놀이기구
time = list(map(int, input().split()))

if N <= M:
    print(N)

else:
    # 5. 이분탐색
    # N명이 다 타는 시간 찾기
    left, right = min(time), max(time) * N
    rlt = 0
    while left <= right:
        mid = (left + right) // 2

        people = numForT(mid, time)

        if people >= N - M:
            right = mid - 1
            rlt = mid
        else:
            left = mid + 1


    # 6. result
    k = N - M - numForT(rlt - 1, time)  # 남은 아이
    print(findLast(k, rlt, time))