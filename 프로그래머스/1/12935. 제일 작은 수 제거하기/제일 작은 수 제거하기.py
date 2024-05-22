def solution(arr):
    # 가장 작은 수 제거
    if len(arr) == 1:
        return [-1]
    
    arr.remove(min(arr))
    
    return arr