def solution(data, ext, val_ext, sort_by):
    answer = []
    stand = ["code", "date", "maximum", "remain"]
    
    # 1. ext 값이 val_ext 보다 작은 데이터만
    del_stand = stand.index(ext)
    
    for d in data:
        if d[del_stand] < val_ext:
            answer.append(d)
          
        
    # 2. 정렬
    sort_stand = stand.index(sort_by)
    answer.sort(key = lambda x: x[sort_stand])
   

    return answer