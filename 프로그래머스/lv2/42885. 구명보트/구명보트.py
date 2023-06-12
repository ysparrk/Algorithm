'''
구명 보트를 최대한 적게 사용
1. 정렬
2. 최대한 limit에 맞추기 -> 최저와 짝이 되는 것 찾기
'''
def solution(people, limit):

    # 1. sort    
    people.sort()
    
    # 2.
    i = 0
    j = len(people) - 1
    cnt = 0
    while i <= j:
        if i == j:
            cnt += 1
            break
        if people[i] + people[j] <= limit:
            cnt += 1
            i += 1
            j -= 1
        else:
            cnt += 1
            j -= 1      

    return cnt