def solution(n, lost, reserve):
    n -= len(lost) 
    
    lost.sort()
    reserve.sort()
    
    # 도난당한 사람 == 여벌 -> 먼저 제거
    for l in lost:
        if l in reserve:
            n += 1
            reserve.remove(l)
        elif (l-1) in reserve and (l-1) not in lost:
            n += 1
            reserve.remove(l-1)
        elif (l+1) in reserve and (l+1) not in lost:
            n += 1
            reserve.remove(l+1)
    
    return n