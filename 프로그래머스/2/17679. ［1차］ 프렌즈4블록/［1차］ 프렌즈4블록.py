from collections import deque


def solution(m, n, board):
    
    # 1. 
    def find_square(x, y, del_lst):
        '''
        1. (x, y)점을 시작으로 2*2가 완성되는지 확인
        2. 완성되면 del_lst에 j를 기준으로 i를 add
        '''

        for i in range(3):
            kx, ky = x + dx[i], y + dy[i]
            
            # 같은지 확인...
            if board[x][y] != board[kx][ky]:
                return False
            
        
        # 그럼 됐으니까 이걸 저장해야 한다 -> 사라지기는 j열을 기준으로 함. 해당 j에 i를 기록
        del_lst[y].update([x, x + 1])
        del_lst[y + 1].update([x, x + 1])
        return True
    
    # 2. 
    def del_sqaure(j, del_lst):
        '''
        해당 j열에 대해 사라지게 하고 위를 내리기
        '''
        cnt = 0
        lst = sorted(del_lst[j])
        
        for i in lst:
            cnt += 1
            board[i][j] = '0' # 지우기
        
            if i != 0:    
                # 이제 그 위를 모두 당기기 0 ~ i-1 까지 i+1하기
                for k in range(i, 0, -1):
                    # 0이 아닌곳만
                    if board[k-1][j] != '0':
                        board[k][j] = board[k-1][j]
                        board[k-1][j] = '0'

        return cnt
    
    # 3.
    def main():
        
        del_lst = [set() for _ in range(n)]  # 지울 리스트
        # 3-1) 사각형 확인
        for i in range(m - 1):
            for j in range(n - 1):
                if board[i][j] != '0':
                    find_square(i, j, del_lst)
                    
        # 3-2) 사라지게 하기, 빈자리 채우기
        cnt_tmp = 0
        for j in range(n):
            cnt_tmp += del_sqaure(j, del_lst)
     
        return cnt_tmp
    
    
    # 4. 함수 돌리기
    dx = [1, 1, 0]
    dy = [0, 1, 1]
    
    for i in range(m):
        board[i] = list(board[i])
    
    rlt = 0
    while True:
        c = main()
        if c == 0:
            break
            
        rlt += c

    return rlt