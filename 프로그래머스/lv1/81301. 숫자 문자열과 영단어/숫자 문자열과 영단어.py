def solution(s):
    answer = ''
    
    numbers = {
        'zero': '0',
        'one': '1',
        'two': '2',
        'three': '3',
        'four': '4',
        'five': '5',
        'six': '6',
        'seven': '7',
        'eight': '8',
        'nine': '9'
    }
    text = ''
    for i in s:
        if text in numbers:
            answer += numbers[text]
            text = ''
        
        # 숫자 x
        if i.isdecimal() == False: 
            text += i
        
        # 숫자
        else :
            answer += i
    
    # 마지막 확인
    if text in numbers:
        answer += numbers[text]
     
    return int(answer)