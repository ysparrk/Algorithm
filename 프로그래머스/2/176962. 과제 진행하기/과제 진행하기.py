from collections import deque

# 1. hour -> minute
def make_time(str):
        h, m = map(int, str.split(':'))
        minute = h * 60 + m
        return minute
    

def solution(plans):
    
    # 2. 
    rlt = []
    plans.sort(key=lambda x : x[1])
    
    q = deque()
    time = make_time(plans[0][1])  # 실질적인 현재 시간
    for p in plans:
        
        ntime = make_time(p[1])  # 현재 시각
        np = int(p[2])  # 현재 플레이 시간
        
        # q가 비어있지 않으면, -> 현재의 시간에 q에 있는 것들이 끝났는지 확인한다
        while q:

            bquest, bp = q.popleft()
            #1) 아직 안끝남
            if time + bp > ntime:
                q.appendleft((bquest, time + bp - ntime))  # 과거 
                break

            #2) 끝남
            else:
                rlt.append(bquest)
                time += bp

        # 현재 작동중인 것 넣기
        q.appendleft((p[0], np))
        time = ntime # 시간 -> ntime으로 갱신
        
    # 마지막 정리
    while q:
        bquest, _ = q.popleft()
        
        rlt.append(bquest)
    
    
    return rlt