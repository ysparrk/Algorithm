T = 10
for tc in range(1, T + 1):
    # 1
    # input, p만큼 슬라이싱해서 palindrome인지 확인 후 cnt +1
    p = int(input())  # palindrome 길이
    arr = [list(input()) for _ in range(8)]  # 8*8 arr
    cnt = 0

    # 2-1. 행(가로)
    for i in range(8):
        for j in range(9 - p):
            if arr[i][j : j + p] == (arr[i][j : j + p])[::-1]:
                cnt += 1

    # 2-2. 열(세로)
    for j in range(8):
        str_lst = []
        for i in range(8):
            str_lst.append(arr[i][j])  # 세로로 된 문자열 리스트로 만들기

        for k in range(0, 9 - p):
            new_str = str_lst[k: k + p]   # p만큼 슬라이싱
            if new_str == new_str[::-1]:  # palindrome 확인
                cnt += 1

    print(f'#{tc} {cnt}')