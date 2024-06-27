from collections import deque


def check_s(s):
    
    while True:
        if "()" in s: 
            s = s.replace("()","")
        elif "{}" in s: 
            s = s.replace("{}","")
        elif "[]" in s: 
            s = s.replace("[]","")
        else:
            # s가 비어있는지 확인
            if s:
                return False
            else:
                return True
            

def solution(s):
    cnt = 0
    q = deque(s)
    
    for i in range(len(s)):
        if check_s(''.join(q)):
            cnt += 1
            
        q.rotate(-1)  # 왼쪽으로 이동
    
    
    return cnt