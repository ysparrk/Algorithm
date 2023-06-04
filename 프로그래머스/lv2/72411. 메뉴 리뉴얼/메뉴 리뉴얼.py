'''
1. orders 정렬
2. orders에서 한사람씩 만들 수 있는 코스 만들기 -> 딕셔너리에 개수 저장
3. 각 dict의 max value의 key 저장
4. key 정렬
'''

from itertools import combinations

def solution(orders, course):
    answer = []
    
    # orders.sort
    for i in range(len(orders)):
        orders[i] = ''.join(sorted(orders[i]))
    
    # dictionary
    for c in course:
        ans = {}     
        for o in orders:        
            sub = combinations(o, c)
            for s in sub:
                if s not in ans:
                    ans[s] = 1
                else:
                    ans[s] += 1

        # max value
        for key, value in ans.items():
            if max(ans.values()) > 1:
                if value == max(ans.values()):
                    answer.append(''.join(key))  # tuple unpaking
            else:
                break    
    
    answer.sort()
    
    return answer