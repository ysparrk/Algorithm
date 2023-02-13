'''




'''


import sys
sys.stdin = open('sample_input.txt')

T = int(input())

for tc in range(1, T + 1):

    bracket = list(input())
    stack = [0] * len(bracket)  # 빈스택

    top = -1
    for i in range(len(bracket)):
        # 2. (, { 일때 push
        # 2-1
        if top >= -1 and bracket[i] == '(':
            top += 1
            stack[top] = bracket[i]
        # 2-2
        elif top >= -1 and bracket[i] == '{':
            top += 1
            stack[top] = bracket[i]

        # 3. ), }가 나오면, 전단계에 짝이 되는 괄호가 있을때 pop, 아니면 break
        # 3-1
        elif bracket[i] == ')':
            top -= 1
            if stack[top + 1] == '(':
                del stack[top + 1]
            else:
                top = 0
                break
        # 3-2
        elif bracket[i] == '}':
            top -= 1
            if stack[top + 1] == '{':
                del stack[top + 1]
            else:
                top = 0
                break

    # 4
    # 출력
    if top == -1:
        print(f'#{tc} 1')
    else:
        print(f'#{tc} 0')
