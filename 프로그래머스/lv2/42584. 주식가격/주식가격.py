'''
1. answer를 max로 채우기
2. stack의 초기값은 0
3. 상승하는 가격의 index를 stack에 넣기
4. answer = 하락index - 내index 
'''
def solution(prices):
    l = len(prices)
    answer = [i for i in range(l-1, -1, -1)] 
    
    stack = [0] # 초기값
    for i in range(1, l):
        while stack and prices[stack[-1]] > prices[i]: # 하락
            p = stack.pop()
            answer[p] = i - p
        
        stack.append(i)
    return answer