def solution(n, build_frame):
    rlt = []

    # 1. 설치가 성립하는지 확인
    def check():
        
        for x, y, a in rlt:
            
            # 1) 기둥 성립 안하는 경우
            # 바닥 위 X
            # (x-1, y) (x, y)에 보 X
            # (x, y-1)에 기둥 X
            if a == 0:
                if y != 0 and [x-1, y, 1] not in rlt and [x, y, 1] not in rlt and [x, y-1, 0] not in rlt:
                    return False
             
            # 2) 보 성립 안하는 경우
            # (x, y-1) (x+1, y-1) 둘 중 하나에 기둥 X
            # (x-1, y) (x+1, y) 연결된 보 X
            else:
                if [x, y-1, 0] not in rlt and [x+1, y-1, 0] not in rlt and ([x-1, y, 1] not in rlt or [x+1, y, 1] not in rlt):
                    return False
                    
        return True
    

    # 2. result
    for x, y, a, b in build_frame:
        
        # 1) 설치
        if b == 1:
            rlt.append([x, y, a])
            if not check():
                rlt.remove([x, y, a])
            
        # 2) 삭제
        else:
            rlt.remove([x, y, a])
            if not check():
                rlt.append([x, y, a])
    
    # 3. 정렬
    rlt.sort(key=lambda x: (x[0], x[1], x[2]))
    
    return rlt