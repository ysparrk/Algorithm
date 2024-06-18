from itertools import permutations

def solution(k, dungeons):
    
    rlt = 0
       
    N = len(dungeons)
    
    for permute in permutations(dungeons, N):
        tmp = k
        cnt = 0
        
        for p in permute:
            if tmp >= p[0]:
                tmp -= p[1]
                cnt += 1
                
            if cnt > rlt:
                rlt = cnt

    return rlt