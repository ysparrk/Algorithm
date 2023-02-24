T = int(input())

for tc in range(1, T + 1):

    n = int(input())

    # 조건문, n == x^3 만족하면 print
    # range의 범위는 세제곱하면 n의 가장 큰 수 10^18이 되는 10^6
    for x in range(1, (10 ** 6) + 1):
        if x ** 3 == n:
            print(f'#{tc} {x}')
            break
    else:
        print(f'#{tc} -1')