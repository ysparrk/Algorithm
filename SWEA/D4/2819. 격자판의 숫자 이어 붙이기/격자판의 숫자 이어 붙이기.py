# 1
def dfs(x, y, rlt):

    if len(rlt) == 7:
        numbers.add(rlt)
        return
    else:
        for di, dj in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            i, j = x + di, y + dj
            if 0 <= i < 4 and 0 <= j < 4:
                dfs(i, j, rlt + board[i][j])

# 2
T = int(input())

for tc in range(1, T + 1):

    board = [list(input().split()) for _ in range(4)]
    rlt = ''
    numbers = set()

    for i in range(4):
        for j in range(4):
            dfs(i, j, rlt)

    print(f'#{tc} {len(numbers)}')