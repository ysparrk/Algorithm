def solution(board, skill):

    # 1. 공격/회복 -> 지점 찍기
    def point_cum_sum(s):
        type, r1, c1, r2, c2, degree = s[0], s[1], s[2], s[3], s[4], s[5]
        state = 1
        
        if type == 2:
            state = -1
        
        cum_sum[r1][c1] += degree * state * -1
        cum_sum[r1][c2 + 1] += degree * state
        cum_sum[r2 + 1][c1] += degree * state
        cum_sum[r2 + 1][c2 + 1] += degree * state * -1
        
        
    # 2. 공격/회복 누적합 만들기
    def make_cum_sum():
        # row 먼저 -> 처음, 끝
        for i in range(N):
            for j in range(M):
                cum_sum[i][j + 1] += cum_sum[i][j]

        # col -> 밑으로 내리기
        for i in range(N):
            for j in range(M):
                cum_sum[i + 1][j] += cum_sum[i][j]
   
    
    # 3. 파괴되지 않은 건물 찾기
    def find_alive():
        cnt = 0
        for i in range(N):
            for j in range(M):
                board[i][j] += cum_sum[i][j]
                if board[i][j] > 0:
                    cnt += 1

        return cnt
    
    
    # 4. result
    N = len(board)
    M = len(board[0])
    cum_sum = [[0] * (M + 1) for _ in range(N + 1)]
    for s in skill:
        point_cum_sum(s)
        
    make_cum_sum()
    rlt = find_alive()
    
    return rlt