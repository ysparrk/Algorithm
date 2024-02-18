# 1. input
D, N, M = map(int, input().split())  # 거리, 돌섬 수, 제거 가능 수

stone = [int(input()) for _ in range(N)]
stone.sort()


# 2. Binary Search
left, right = 0, D
rlt = 0
while left <= right:

    mid = (left + right) // 2
    cnt = 0  # 제거한 돌 개수
    now = 0  # 현재의 돌 사이 거리
    temp = D  # 점프 거리 최솟값

    for s in stone:
        # 현재의 돌과 다음 돌의 거리가 mid보다 크면
        if s - now >= mid:
            temp = min(temp, s - now)
            now = s
        else:
            cnt += 1  # 돌 제거

    temp = min(temp, D - now)  # 마지막 최솟값

    # 돌을 더 많이 제거했다 -> mid가 크다
    if cnt > M:
        right = mid - 1
    # 돌을 덜 제거했다 -> mid가 작다
    else:
        rlt = max(rlt, temp)  # 현재의 점프거리 최솟값과 비교해서 최댓값으로 rlt 변경
        left = mid + 1


print(rlt)