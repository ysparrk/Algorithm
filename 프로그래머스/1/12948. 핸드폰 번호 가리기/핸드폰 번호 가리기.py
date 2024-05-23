def solution(phone_number):
    
    N = len(phone_number)
    
    rlt = '*' * (N - 4) + phone_number[N-4:]
    
    return rlt