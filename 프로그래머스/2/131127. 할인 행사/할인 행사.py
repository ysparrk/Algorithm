def solution(want, number, discount):

    # 1) 딕셔너리로 만들기
    want_dict = {}
    for i in range(len(want)):
        want_dict[want[i]] = number[i]
    
    
    # 2) 딕셔너리 비교
    def compare_dict(want_dict, tmp_dict):
        
        for key, value in tmp_dict.items():
            
            # key가 없는데, value가 있으면
            if key not in want_dict:
                if value > 0:
                    return False
            else:
                if value > want_dict[key]:
                    return False
        return True
    

    # 3) 초기 값
    tmp_dict = {}
    rlt = 0
    for i in range(10):
                
        if discount[i] in tmp_dict:
            tmp_dict[discount[i]] += 1

        else:
            tmp_dict[discount[i]] = 1

    # 비교
    if compare_dict(want_dict, tmp_dict):
        rlt += 1

            
    # 4) result
    for i in range(10, len(discount)):
           
        tmp_dict[discount[i-10]] -= 1


        if discount[i] in tmp_dict:
            tmp_dict[discount[i]] += 1

        else:
            tmp_dict[discount[i]] = 1
        
        # 비교
        if compare_dict(want_dict, tmp_dict):
            rlt += 1
            
    return rlt