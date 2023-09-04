def solution(board, moves):
    cnt = 0
    basket = [-1]
    
    for m in moves:
        i = 0
        while i < len(board):
                
            if board[i][m-1] == basket[-1]:
                basket.pop(-1)
                board[i][m-1] = 0
                cnt += 2
                break
            
            elif board[i][m-1]:
                basket.append(board[i][m-1])
                board[i][m-1] = 0
                break
                
            else:
                i += 1
    
    
    return cnt