def solution(s):
    
    # 팰린드롬 여부 확인
    def is_palindrome(str):
        if str == str[::-1]:
            return True
        
        return False
    
    # result
    rlt = 0
    N = len(s)
    for i in range(N):
        for j in range(i + 1, N + 1):
            if is_palindrome(s[i : j]):
                rlt = max(rlt, len(s[i : j]))
            
            
    return rlt