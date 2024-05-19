def solution(genres, plays):
    N = len(genres)
    
    g_dict = {}
    p_dict = {}
    
    
    for i in range(N):
        g = genres[i]
        
        if g in g_dict:
            g_dict[g] += plays[i]
            p_dict[g].append((i, plays[i]))
        else:
            g_dict[g] = plays[i]
            p_dict[g] = [(i, plays[i])]
            
    # 장르 딕셔너리 정렬
    s_dict = sorted(g_dict.items(), key=lambda x : x[1], reverse = True)
    
    # result
    rlt = []
    for g, p in s_dict:
        print(g)
        # 노래 하나
        if len(p_dict[g]) == 1:
            rlt.append(p_dict[g][0][0])
            
        else:
            tmp = sorted(p_dict[g], key=lambda x : x[1], reverse = True)
    
            rlt.append(tmp[0][0])
            rlt.append(tmp[1][0])
        
        
    return rlt