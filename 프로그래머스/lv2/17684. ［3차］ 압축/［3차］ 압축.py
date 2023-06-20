def solution(msg):
    answer = []
    word = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']
    word_plus = []
    
    i = 0
    temp = ''
    while i < len(msg):
        
        sub = temp
        temp += msg[i]
        
        if temp in word:
            i += 1

        else: 
            answer.append(word.index(sub) + 1)  # 처리됨
            word.append(temp)
            temp = ''
    
    answer.append(word.index(temp) + 1)
   
    return answer