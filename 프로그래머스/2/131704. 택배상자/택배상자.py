from collections import deque

def solution(order):
    rlt = 0
    N = len(order)
    sub = deque([])
    
    
    now = 1
    for o in order:
        if o == now:
            rlt += 1
            now += 1

        else:
            # 1) sub 빔
            if sub == deque([]):
                sub.append(now)
                now += 1
                
            # 2)
            if sub[-1] == o:
                rlt += 1
                sub.pop()
                continue
            
            # 3) 같아질때까지 넣는다
            while now != o:
                
                # 불가 조건
                if sub[-1] > o:
                    return rlt
                
                if now == N+1:
                    return rlt
                
                sub.append(now)
                now += 1
            
            # 4) while 빠져나가면
            rlt += 1
            now += 1
        
    return rlt