from collections import deque


def solution(board, h, w):

    N = len(board)
    cnt = 0

    dh = [1, -1, 0, 0]
    dw = [0, 0, 1, -1]

    for i in range(4):
        kh, kw = h + dh[i], w + dw[i]
        # 이동 가능
        if 0 <= kh < N and 0 <= kw < N:
            if board[kh][kw] == board[h][w]:
                cnt += 1

    return cnt