# 0. input
n, l = map(int, input().split())  # 신호등 개수, 도로 길이


# 1. result
truck = 0  # 트럭 위치
cnt = 0 # 초
for _ in range(n):
    d, r, g = map(int, input().split())
    cnt += d - truck
    truck = d

    if cnt % (r+g) <= r:
        cnt += (r - (cnt % (r+g)))

cnt += (l-truck)
print(cnt)