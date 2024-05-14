def solution(storey):
    
    rlt = 0
    while storey:
        
        tmp = storey % 10

        if tmp > 5:
            rlt += (10 - tmp)
            storey += 10
        elif tmp < 5:
            rlt += tmp
        else:
            if (storey // 10) % 10 >= 5:
                storey += 10
            rlt += tmp
            
        storey //= 10

    return rlt