score, min_score = 0, 0
rlt = [0] * 11
def solution(n, info):
      
    def backtracking(idx, lion, peach, rest_arrow, min_arrow, rlt_tmp):
        global score, rlt, min_score
        
        # 1. 종료 조건
        if idx == -1:
            # 1) 남은 화살 0점에 다 넣기
            if rest_arrow > 0:
                rlt_tmp[10] += rest_arrow
                min_arrow = 0
            
            # 2) 차이가 더 클 경우
            if lion > peach and (lion - peach) > score:
                score = lion - peach
                min_score = min_arrow
                rlt = rlt_tmp.copy()
            
            # 3) 더 낮은 점수 획득
            elif lion > peach and (lion - peach) == score:
                if min_arrow < min_score:
                    min_score = min_arrow
                    rlt = rlt_tmp.copy()
            return
        
        
        # 2. 점수 만들기
        # 1) 라이언 승
        if rest_arrow - (info[10 - idx] + 1) >= 0:
            rlt_tmp[10 - idx] = info[10 - idx] + 1
            backtracking(idx - 1, lion + idx, peach, rest_arrow - (info[10 - idx] + 1), idx, rlt_tmp)
        
        # 2) 어피치 승
        if info[10 - idx] > 0:
            rlt_tmp[10 - idx] = 0
            backtracking(idx - 1, lion, peach + idx, rest_arrow, min_arrow, rlt_tmp)
        
        # 3) 동점
        if rest_arrow - info[10 - idx] >= 0 and info[10 - idx] > 0:
            rlt_tmp[10 - idx] = info[10 - idx]
            backtracking(idx - 1, lion, peach + idx, rest_arrow - info[10 - idx], idx, rlt_tmp)
            
        # 4) 둘다 0
        if info[10 - idx] == 0:
            rlt_tmp[10 - idx] = 0
            backtracking(idx - 1, lion, peach, rest_arrow, min_arrow, rlt_tmp)
        
        
    # 3. 백트래킹 실행  
    backtracking(10, 0, 0, n, 10, rlt)
    
    if score == 0:
        return [-1]
         
    return rlt