T = int(input())
for tc in range(1, T + 1):

    lst = [input() for _ in range(5)]
    lst_size = [len(i) for i in lst]

    # try-except에서 글자가 없어 out of range error 발생 => continue
    print(f'#{tc}' ,end=' ')
    for j in range(max(lst_size)):
        for i in range(5):
            try:
                print(lst[i][j], end='')  # 이어서 프린트하기

            except:
                continue
    print()