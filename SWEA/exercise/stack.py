'''
스택을 구현
구현한 스택을 이용하여 3개의 데이터를 스택에 저장하고 다시 3번 꺼내서 출력
'''

stack = [0] * 3  # 크기가 정해진 스택을 만들어 놓고 시작한다.
top = -1

top += 1 # push(10), 10을 push하고 싶다면
stack[top] = 10  # top이 가르키는 위치에 10을 넣어라

top += 1
stack[top] = 20

top += 1
stack[top] = 30

top -= 1
print(stack[top + 1])

top -= 1
print(stack[top + 1])

top -= 1
print(stack[top + 1])