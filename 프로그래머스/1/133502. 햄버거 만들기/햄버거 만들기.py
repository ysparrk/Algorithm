def solution(ingredient):
    tmp = []
    cnt = 0
    
    for i in ingredient:
        tmp.append(i)
        
        if tmp[-4:] == [1, 2, 3, 1]:
            cnt += 1
            for _ in range(4):
                tmp.pop()
    return cnt