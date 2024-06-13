def solution(board):

    cntO = 0
    cntX = 0
    wins = [0] * 8  # 가로, 세로, 대각선 체크
    for i in range(3):
        for j in range(3):
            if board[i][j] == 'O':
                cntO += 1
                wins[i] += 1
                wins[j + 3] += 1
                
                # 대각선
                if i == j:
                    wins[6] += 1
                
                if (i == 0 and j == 2) or (i == 2 and j == 0) or (i == 1 and j == 1):
                    wins[7] += 1
                

            elif board[i][j] == 'X':
                cntX += 1
                wins[i] -= 1
                wins[j + 3] -= 1
                
                # 대각선
                if i == j:
                    wins[6] -= 1
                
                if (i == 0 and j == 2) or (i == 2 and j == 0) or (i == 1 and j == 1):
                    wins[7] -= 1


    # result
    # 0) O, X 둘 다 이기는 경우
    if wins.count(3) >= 1 and wins.count(-3) >= 1:
        return 0
    
    
    # 1) O승리
    if 3 in wins:
        if cntO == (cntX + 1):
            return 1
        return 0
    
    
    # 2) X 승리
    if -3 in wins:
        if cntO == cntX:
            return 1
        print("여기")
        return 0
    
        
    # 3) 진행 중
    if cntO == cntX or cntO == (cntX + 1):
        return 1
    return 0