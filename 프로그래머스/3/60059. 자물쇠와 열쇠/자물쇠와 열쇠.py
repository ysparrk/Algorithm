def solution(key, lock):

    # 1. 90도 회전
    def rotate(key):
        
        rotate_tmp = [[0] * M for _ in range(M)]
        
        for i in range(M):
            for j in range(M):
                rotate_tmp[j][M - i - 1] = key[i][j]

        return rotate_tmp
        
        
    # 2. x, y에서 시작 -> key가 맞는지 확인
    def check(x, y):
        # 정중앙이 다 1로 채워지는지 확인
        for i in range(N, 2 * N):
            for j in range(N, 2 * N):
                tmp = new_lock[i][j]
                # key가 범위에 있으면 더하기
                if x <= i < x + M and y <= j < y + M:
                    tmp += key[i - x][j - y]

                if tmp != 1:
                    return False

        return True

   
    # 3. result 
    M = len(key)
    N = len(lock)
    
    # 1) 원본의 3배 크기 자물쇠 -> 정중앙에 기존 자물쇠 넣기
    new_lock = [[0 for _ in range(N * 3)] for _ in range(N * 3)]
    for i in range(N):
        for j in range(N):
            new_lock[N + i][N + j] = lock[i][j]
            
    # 2) 탐색
    # (1, 1) ~ (2N, 2N)
    for k in range(4):
        for i in range(1, N * 2):
            for j in range(1, N * 2):
                if check(i, j):
                    return True
                
        key = rotate(key)
     
    return False