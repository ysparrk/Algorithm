from collections import Counter

def solution(topping):

    numsA = {}
    numsB = dict(Counter(topping))
    
    
    rlt = 0
    for t in topping:
        
        if len(numsA) == len(numsB):
            rlt += 1
       
    
        # numsA 값 추가
        if t not in numsA:
            numsA[t] = 1


        if numsB[t] == 1:
            numsB.pop(t)
        else:
            numsB[t] -= 1
            
    
    return rlt