'''
16진수 > 4자리 2진수
'''

# 1
# 10진수 > 2진수 변환 함수
def binary(n):
    if n == 0:
        return '0'
    elif n == 1:
        return '1'
    elif (n % 2 == 0):
        return binary(n // 2) + '0'
    else:
        return binary(n // 2) + '1'

# 2
T = int(input())

for tc in range(1, T + 1):
    n, num = map(str, input().split())

    # 2-1
    # 16진수 > 10진수 숫자
    decimal = [0] * int(n) # 각 자리수 담는 lst
    for i in range(int(n)):

        if num[i].isdecimal():  # 숫자라면
            decimal[i] = int(num[i])
        else:                     # 알파벳이라면, 16진수 표기에 따른 10진수 변환
            if num[i] == 'A':
                k = 10
            elif num[i] == 'B':
                k = 11
            elif num[i] == 'C':
                k = 12
            elif num[i] == 'D':
                k = 13
            elif num[i] == 'E':
                k = 14
            elif num[i] == 'F':
                k = 15
            decimal[i] = k

    # 3
    # 출력, 4자리가 아닌 이진수 0 채우기
    print(f'#{tc}', end=' ')
    for i in range(int(n)):
        k = binary(decimal[i])
        while len(k) < 4: # 길이가 4 이하면, 앞에 0 채우기
            k = '0' + k
        print(k, end='')
    print()

