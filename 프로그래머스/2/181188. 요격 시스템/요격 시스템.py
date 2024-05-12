def solution(targets):
    rlt = 0
    
    targets.sort(key=lambda x: [x[1], x[0]])
    
    e = 0
    for t in targets:
        if t[0] >= e:
            rlt += 1
            e = t[1]
    
    return rlt