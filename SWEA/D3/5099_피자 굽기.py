'''


'''
import sys
sys.stdin = open('sample_input_피자.txt')

T = int(input())

for tc in range(1, T + 1):
    # 1
    n, m = map(int, input().split()) # 화덕 크기, 피자 개수
    cheese = list(map(int, input().split())) # 치즈 양
    stack = [] # 화덕
    idx = [] # 넣는 피자의 idx

    # 2
    # 피자를 다 넣을 때 까지 while문
    i = 0
    while i < m:
        if i < m and len(stack) < n: # 1) 피자가 다 들어가지 않은 경우 > 피자 넣기
            stack.append(cheese[i])
            idx.append(i)
            i += 1
        elif i < m and len(stack) == n:
            pizza = stack.pop(0)  # 가장 앞에 있는 피자 pop해서 치즈 확인
            num = idx.pop(0)
            if pizza // 2 == 0:  # 치즈가 녹았다면, 피자 추가
                stack.append(cheese[i])
                idx.append(i)
                i += 1  # 0이라면
            else:
                stack.append(pizza // 2)  # 0이 아니라면 치즈만 녹여서 다시 append
                idx.append(num)

    # 3
    # 피자를 다 넣고 나서 stack에 피자가 하나만 남을 때까지
    # 치즈 녹았는지 확인 + 빼기/넣기 반복
    while len(stack) > 1:
        pizza = stack.pop(0)
        num = idx.pop(0)
        if pizza // 2 != 0:
            stack.append(pizza // 2)
            idx.append(num)

    print(f'#{tc} {idx[0] + 1}')