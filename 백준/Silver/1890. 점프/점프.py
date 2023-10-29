# 1. import
N = int(input())
board = [list(map(int,input().split())) for _ in range(N)]
check = [[0] * N for _ in range(N)]


# 2.
check[0][0] = 1
for i in range(N):
    for j in range(N):
        if board[i][j] != 0 and check[i][j] != 0:
            if i + board[i][j] < N:
                check[i + board[i][j]][j] += check[i][j]

            if j + board[i][j] < N:
                check[i][j + board[i][j]] += check[i][j]

print(check[-1][-1])