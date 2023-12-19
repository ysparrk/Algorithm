def solution(keymap, targets):
    # 1. setting
    answer = []
    
    words_dict = {'A': 10000, 'B': 10000, 'C': 10000, 'D': 10000, 'E': 10000, 'F': 10000, 'G': 10000, 'H': 10000, 'I': 10000, 'J': 10000, 'K': 10000, 'L': 10000, 'M': 10000, 'N': 10000, 'O': 10000, 'P': 10000, 'Q': 10000, 'R': 10000, 'S': 10000, 'T': 10000, 'U': 10000, 'V': 10000, 'W': 10000, 'X': 10000, 'Y': 10000, 'Z': 10000}
    
    # 2. 비교
    for i in range(len(keymap)):
        cnt = 0
        for j in range(len(keymap[i])):
            cnt += 1
            # 딕셔너리에서 비교해서 넣기
            words_dict[keymap[i][j]] = min(cnt, words_dict[keymap[i][j]])
    
    # 3. result
    for i in range(len(targets)):
        rlt = 0
        for j in range(len(targets[i])):
            rlt += words_dict[targets[i][j]]
        
        if rlt >= 10000:
            rlt = -1
        answer.append(rlt)
    
    return answer