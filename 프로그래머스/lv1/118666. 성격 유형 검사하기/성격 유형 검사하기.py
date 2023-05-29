def solution(survey, choices):
    # rt, cf, jm, an  321 123
    
    rlt = {
        'R': 0, 'T': 0, 'C': 0, 'F': 0, 'J': 0, 'M': 0, 'A': 0, 'N': 0
    }
    
    # score
    for i in range(len(survey)):
        
        if choices[i] <= 3:
            rlt[survey[i][0]] += (4 - choices[i])
            
        elif choices[i] >= 5:
            rlt[survey[i][1]] += (choices[i] - 4)
    
    
    # result
    answer = ''
    if rlt['R'] >= rlt['T']:
        answer += 'R'
    else:
        answer += 'T'
    
    if rlt['C'] >= rlt['F']:
        answer += 'C'
    else:
        answer += 'F'
    
    if rlt['J'] >= rlt['M']:
        answer += 'J'
    else:
        answer += 'M'

    if rlt['A'] >= rlt['N']:
        answer += 'A'
    else:
        answer += 'N'
        
    return answer