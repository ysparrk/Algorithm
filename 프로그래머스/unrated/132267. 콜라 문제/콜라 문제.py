def solution(a, b, n):
    answer = 0
    
    while n >= a:
        answer += (n // a) * b  # 콜라 받기
        n = (n // a) * b + (n % a) # 현재 빈병 수

    return answer