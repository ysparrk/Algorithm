T = int(input())

for tc in range(1, T + 1):
    # 1. 초기설정
    infix = list(input().split())
    infix = infix[:-1]  # 마지막 .제거하는 슬라이싱
    stack = []

    # 2
    # 계산하기
    # 피연산자는 => stack에 push
    # 연산자는 stack에서 2개를 pop해서 계산하고 그 값을 다시 stack에 push
    for token in infix:
        try:
            if token.isdecimal():
                stack.append(token)
            else:
                if token == '*':
                    rlt = int(stack.pop(-2)) * int(stack.pop(-1))
                    stack.append(rlt)
                elif token == '/':
                    rlt = int(stack.pop(-2)) // int(stack.pop(-1))
                    stack.append(rlt)
                elif token == '+':
                    rlt = int(stack.pop(-2)) + int(stack.pop(-1))
                    stack.append(rlt)
                elif token == '-':
                    rlt = int(stack.pop(-2)) - int(stack.pop(-1))
                    stack.append(rlt)
        except:
            print(f'#{tc} error')
            break
    # 3
    # 출력
    else:
        if len(stack) == 1:  # stack에 요소가 하나만 있다면, 즉 rlt 하나만 존재할때 그 값 출력.
            print(f'#{tc}', *stack)
        else:                # 연산자가 부족해서 요소가 두개 이상이라면 error
            print(f'#{tc} error')