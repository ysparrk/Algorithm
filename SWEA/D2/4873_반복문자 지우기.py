'''
문자열 s에서 반복된 문자 지우기
'''

T = int(input())

for tc in range(1, T + 1):
    # 1
    s = list(input())
    stack = [0] * len(s)

    top = -1
    for i in range(len(s)):
        # 2-1
        if s[i] == stack[top]:  # s[i]의 값이 stack의 바로 전 값과 같다면, pop
            del stack[top]
            top -= 1
        # 2-2
        else:
            top += 1           # s[i]의 값이 stack의 바로 전 값과 다르다면, push
            stack[top] = s[i]

    print(f'#{tc} {stack.index(0)}')
