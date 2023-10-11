# 1. input
n, m, l = map(int, input().split())  # current, more, length

store = list(map(int, input().split())) + [0, l]
store.sort()

# 2. Binary Search
start, end = 1, l-1
rlt = 0
while start <= end:
    cnt = 0
    mid = (start + end) // 2  # 최대 거리

    for i in range(1, len(store)):
        if store[i] - store[i-1] > mid:
            cnt += (store[i] - store[i-1]-1) // mid  # 나눈 만큼 휴게소 설치

    if cnt > m:
        start = mid + 1

    else:
        end = mid - 1
        rlt = mid

print(rlt)