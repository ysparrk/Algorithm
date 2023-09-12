def solution(new_id):
    new_id = new_id.lower()
    
    answer = ''
    for id in new_id:
        if id.islower() or id.isdigit() or id in '-_.':
            answer += id
    
    while '..' in answer:
        answer = answer.replace('..', '.') # 여러개를 하나로 줄여나감
    
    if len(answer) > 1:
        if answer[0] == '.':
            answer = answer[1:]
        if answer[-1] == '.':
            answer = answer[:-1]
            
    else:
        if answer[0] == '.':
            answer = ''
    
    if answer == '':
        answer = 'a'
    
    if len(answer) >= 16:
        answer = answer[:15]
        if answer[-1] == '.':
            answer = answer[:-1]
    
    while len(answer) <= 2:
        answer += answer[-1]
            
    return answer