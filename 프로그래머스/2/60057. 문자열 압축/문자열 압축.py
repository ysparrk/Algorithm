def solution(s):
    
    # 총 압축된 길이 = (2회 이상 압축된 문자열의 합) + (그냥 문자열의 합)

    rlt = len(s)
    
    for i in range(1, len(s)//2 + 1):
         # 1) i단위 만큼 자름
        tmp = s[:i] 
        cnt = 1
        s_str = ''
        
        for j in range(i, len(s), i):
            
            # 2) tmp와 같은지 확인
            if tmp == s[j:j+i]:
                cnt += 1
            else: 
                if cnt > 1:
                    s_str += str(cnt) + tmp
                else:
                    # 압축이 1회 이하
                    s_str += tmp
                
                # tmp, cnt 갱신
                cnt = 1
                tmp = s[j:j+i]
        
        
        # 3) s_str 만들기
        if cnt > 1:
            s_str += str(cnt) + tmp
        else:
            s_str += tmp
            
        rlt = min(rlt, len(s_str))
            

    return rlt