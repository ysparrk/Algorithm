def solution(record):
    # 준비
    ans = []
    ans_id = []
    ans_state = []
    ans_dict = {}
    
    # save
    for r in record:
        r = r.split()
        if r[0] == 'Enter':
            ans_id.append(r[1])
            ans_state.append(0)
            ans_dict[r[1]] = r[2]
         
        elif r[0] == 'Leave':
            ans_id.append(r[1])
            ans_state.append(1)
            
        elif r[0] == 'Change':       
            ans_dict[r[1]] = r[2]
   
    
    # result
    for i in range(len(ans_id)):
      
        if ans_state[i] == 0:
            ans.append(f'{ans_dict.get(ans_id[i])}님이 들어왔습니다.')

        else:
            ans.append(f'{ans_dict.get(ans_id[i])}님이 나갔습니다.')
    
                        
    return ans