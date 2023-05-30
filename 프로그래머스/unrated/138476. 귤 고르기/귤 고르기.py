def solution(k, tangerine):
  
    # 1. count tangerine
    t_dic = {}
    for t in tangerine:
        if t_dic.get(t):
            t_dic[t] += 1
        else:
            t_dic[t] = 1

      
    # 2. value list
    t_lst = list(t_dic.values())
    t_lst.sort(reverse=True)
    
    
    # 3. subtract max
    answer = 0
    while k > 0:
        t = t_lst.pop(0)
        k -= t
        answer += 1
    
    return answer