def solution(k, score):
    rlt = []
    top = []
    
    for s in score:
        top.append(s)
        top.sort(reverse=True)
        
        rlt.append(top[min(len(top) - 1, k-1)])
            
    return rlt