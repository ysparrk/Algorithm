def solution(numbers):    
    s = list(map(str, numbers))
    ans = sorted(s, key=lambda x: x * 3, reverse = 1)
    
    return str(int("".join(ans)))