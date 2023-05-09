import itertools
# 소수인지 확인
def prime(n):
    if n != 1 and n != 0: 
        for i in range(2, n):
            if n % i == 0:
                return False
        else:
            return True
    else:
        return False    

# 계산
def solution(numbers):
    answer = set() # set에서 중복 제거
    numbers = list(numbers)
    for i in range(1, len(numbers) + 1):  
        nPr = itertools.permutations(numbers, i)
        rlt = list(nPr)
        for j in range(len(rlt)):
            n = ''.join(rlt[j])
            if prime(int(n)):
                answer.add(int(n))

    return len(answer)