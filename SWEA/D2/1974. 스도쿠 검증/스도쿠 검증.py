def sudoku(arr):
    # 1-1. 가로
    for lst in arr:
        if len(set(lst)) != 9:
            return 0

    # 1-2. 세로
    arr_s = list(zip(*arr))
    for lst in arr_s:
        if len(set(lst)) != 9:
            return 0

    # 1-3. 3*3 격자
    for i in (0, 3, 6):
        for j in (0, 3, 6):
            lst = arr[i][j : j + 3] + arr[i + 1][j : j + 3] + arr[i + 2][j : j + 3]
            if len(set(lst)) != 9:
                return 0

    # 1-4. 하나도 false 안걸렸을때 return 1
    return 1

# 2.
# 출력
T = int(input())
for tc in range(1, T + 1):
    arr = [list(map(int, input().split())) for _ in range(9)]  # 9*9
    fin = sudoku(arr)
    print(f'#{tc} {fin}')