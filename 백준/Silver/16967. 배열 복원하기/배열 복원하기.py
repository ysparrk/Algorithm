# 1. input
h, w, x, y = map(int, input().split())
blst = [list(map(int, input().split())) for _ in range(h+x)]

# 2. result
alst = [[0] * w for _ in range(h)]

for i in range(h+x-1, x-1, -1):
    for j in range(w+y-1, y-1, -1):
        blst[i-x][j-y] -= blst[i][j]
        alst[i-x][j-y] = blst[i][j]

for row in alst:
    print(*row)