'''
괄호의 짝을 검사하는 프로그램 작성
4
()()((()))
((()((((()()((()())((())))))
(())(((())()))(()()((()))
))))
true = 1
false = -1
'''

T = int(input())

for tc in range(1, T + 1):

    # 1
    bracket = list(input())  # input 받기
    stack = [0] * len(bracket)  # input받은 괄호의 길이 만큼 빈스택 만들기기
    top = -1

    # 2
    for i in range(len(bracket)):
        if top >= -1 and bracket[i] == '(':   # ( 면 pop한다
            top += 1
            stack[top] = bracket[i]

        elif top >= -1 and bracket[i] == ')':  # )면 전단계를 pop한다, 오류가 나면 false
            top -= 1
            del stack[top + 1]
        else:
            top = 0   # 이외, top을 0으로 하고, break.  -1 프린트 되게 한다.
            break

    # 3
    # 출력
    if top == -1:
        print(f'#{tc} 1')
    else:
        print(f'#{tc} -1')
