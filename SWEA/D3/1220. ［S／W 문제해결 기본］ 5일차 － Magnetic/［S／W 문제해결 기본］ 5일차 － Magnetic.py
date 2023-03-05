T = 10

for tc in range(1, T + 1):
    n = int(input())
    table = [list(map(int, input().split())) for _ in range(n)]

    # 1
    # stack이 비어있고, 1을 만나면 stack에 push
    # stack이 비어있지 않고, 2를 만나면 pop + cnt+1
    cnt = 0
    for j in range(n):
        stack = []
        for i in range(n):
            if stack == [] and table[i][j] == 1:
                stack.append(table[i][j])
            elif stack and table[i][j] == 2:
                stack.pop()
                cnt += 1

    print(f'#{tc} {cnt}')