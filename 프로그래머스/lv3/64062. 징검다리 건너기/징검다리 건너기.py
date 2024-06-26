'''
binary search
- 통과할 수 있는 사람의 max값을 기준으로 이진탐색.
'''

# 1. s만큼의 사람이 통과할 수 있는지 확인
def check(stones, s, k):
    cnt = 0
    for stone in stones:
        if stone < s:
            cnt += 1
        else:
            cnt = 0
    
        if cnt == k:
            return False
    return True

# 2. binary search
def solution(stones, k):
    start = 1  # 최소 한 명은 건널 수 있음
    end = max(stones) + 1
    
    # start와 end가 하나 차이나면 return
    while start < end - 1:
        mid = (start + end) // 2
        if check(stones, mid, k):
            start = mid  # True -> start change
        else:
            end = mid
  
    return start