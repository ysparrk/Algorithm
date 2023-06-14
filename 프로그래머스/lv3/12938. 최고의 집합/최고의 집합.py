def solution(n, s):
    '''
    원소간 차이가 제일 나지 않도록 -> s/n의 몫, 나머지
    1. 몫이 0인 경우 -> 불가능
    2. 나머지가 0인 경우 -> 같은 수 집합
    3. 몫에서 1씩 더하기
    '''
    answer = []
    q, r = divmod(s, n)
    if q == 0:
        answer = [-1]
    elif r == 0:
        answer = [q for _ in range(n)]
    else:
        answer = [q] * (n - r) + [q + 1] * r
        
    return answer