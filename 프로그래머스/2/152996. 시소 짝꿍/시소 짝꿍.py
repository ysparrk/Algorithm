def solution(weights):
  
    w_dict = {}
    
    for wei in weights:
        if wei in w_dict:
            w_dict[wei] += 1
        else:
            w_dict[wei] = 1
            
            
    div = [2, (2/3), (3/4)]       
    cnt = 0
    for w in w_dict:
        # 1) 같은 수가 존재
        if w_dict[w] > 1:
            cnt += (w_dict[w] * (w_dict[w] - 1)) / 2
            
        # 2) 다른 수
        for i in range(3):
            if w * div[i] in w_dict:
                cnt += (w_dict[w] * w_dict[w * div[i]])
                
        
            
    return cnt