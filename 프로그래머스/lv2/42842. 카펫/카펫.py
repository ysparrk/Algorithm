# 1. 약수 구하기 : 1, 2와 짝이 되는 수 제외
def divisor(n):
    data = []

    for i in range(3, n//2):
        if n % i == 0:
            data.append(i)
    return data

# 2. solution
def solution(brown, yellow):

    total = brown + yellow
    sub = divisor(total)
    
    # brown
    for i in range(len(sub)):
        column = sub[i]
        row = sub[-1-i]
        
        if (((row-1) + (column-1)) * 2) == brown:
            return [row, column]
        
