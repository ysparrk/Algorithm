def solution(numbers):
    n = len(numbers)
    answer = [-1] * n
    stack = []
    for i in range(n):
        # stack이 비어있지 않고, stack의 마지막이 numbers[i]보다 작을때까지, 
        while stack and numbers[stack[-1]] < numbers[i]:
            answer[stack.pop()] = numbers[i] # answer 바꾸기
        stack.append(i)
    return answer