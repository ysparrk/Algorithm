def solution(arr):
    answer = []
    answer.append(arr[0])  # 첫번째 원소 넣고 시작
    
    for i in arr:
        if answer[-1] != i:
            answer.append(i)
    
    return answer