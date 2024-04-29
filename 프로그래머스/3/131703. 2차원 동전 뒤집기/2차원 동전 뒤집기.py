import sys

rlt = sys.maxsize

def solution(beginning, target):

    '''
    백트래킹
    1. 행을 뒤집는다 -> dfs
    2. 뒤집은 행 되돌리기 -> dfs
    3. 마지막 행인 경우 -> 열 확인
        - 모두 일치, 모두 불일치 -> 뒤집기 O
        - 부분일치 -> 뒤집기 X
    '''
    
    # 1. row 뒤집기
    def flip_row(i):
        for j in range(M):
            beginning[i][j] = (beginning[i][j] + 1) % 2

    # 2. col 확인
    def check_col(j):
        # j열에 대해 1) 모두 일치 2) 모두 불일치 3) 부분일치 확인
        tmp_c = 0
        for i in range(N):
            if beginning[i][j] == target[i][j]:
                tmp_c += 1
        
        if tmp_c == N:
            return 0
        elif tmp_c == 0:
            return 1
        else:
            return -1

    # 3.
    def dfs(r, cnt):
        global rlt
        
        # 1) N-1 행까지 다 확인
        if r == N:
            flag = True
            for j in range(M):
                tmp = check_col(j)
                if tmp == -1:  # 부분 일치 -> 뒤집지 않는다
                    flag = False
                    break    
                cnt += tmp
            
            # M-1열까지 모두 확인 + 일치 -> rlt 갱신
            if flag:
                rlt = min(rlt, cnt)
            return
        
        # 2) 백트래킹
        else:
            flip_row(r)  # 뒤집기
            dfs(r + 1, cnt + 1) # r행 뒤집기 O

            flip_row(r) # 되돌리기
            dfs(r + 1, cnt)  # r행을 뒤집기 X
    
    
    # 4. result
    N = len(beginning) 
    M = len(beginning[0])
    
    dfs(0, 0)
        
    if rlt == sys.maxsize:
        return -1
    
    else:
        return rlt