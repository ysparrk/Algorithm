'''
10*20, 20*20 직사각형 종이
20*N 크기의 직사각형 표시. 준비한 종이를 빈틈없이 붙이는 방법
점화식... 앞뒤 관계로 접근..
'''


T = int(input())
for tc in range(1, T + 1):
    # 1. 초기설정
    n = int(input()) // 10  # n을 10으로 나눠서 생각
    rlt = [0, 1, 3]  # idx를 쉽게 구별하기 위해 0을 먼저 넣고, n이 1, 2인 경우 추가

    # 2.
    # 점화식
    # n일 때, 전전의 값 + 전의 값 *2가 된다는 규칙이 있다.
    i = 3
    while i <= n:
        if n <= 2:
            print(f'#{tc} {rlt[n]}')  # n이 2이하인 경우, rlt에서 바로 출력.
        elif i == n:
            print(f'#{tc} {rlt[i - 1] + 2 * rlt[i - 2]}')  # i == n인 경우 점화식 출력
            break
        else:
            rlt.append(rlt[i - 1] + 2 * rlt[i - 2])  # i가 n이 되기 전까지 rlt에 추가
            i += 1