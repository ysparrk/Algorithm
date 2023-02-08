import sys
sys.stdin = open('sample_input2.txt')

T = int(input())

for tc in range(1, T + 1):
    # 1
    # n*n 배열을 만들어서 주어진 문자열을 다 받는다.
    n, m = map(int, input().split())
    arr = [list(input()) for _ in range(n)]

    # 2-1. 가로(행)
    # 행 우선순회를 통해 행에서 비교
    for i in range(n):
        str_lst = []
        for j in range(n):
            str_lst.append(arr[i][j])  # i행의 알파벳들을 str_lst에 하나씩 넣기

        # 3
        # 알파벳이 하나씩 담긴 리스트를 하나 만든 후, palindrome인지 비교
        for k in range(0, n - m + 1):     # 요소가 n개인 리스트에서 m만큼 슬라이싱, 모든 경우 확인 + range 확인 중요!!
            new_str = str_lst[k : k + m]  # new_str은 슬라이싱 된 리스트
            if new_str == new_str[::-1]:  # palindrome 인지 확인
                print(f'#{tc} {"".join(new_str)}')

    # 2-2. 세로(행)
    for j in range(n):
        str_lst = []
        for i in range(n):
            str_lst.append(arr[i][j])

        for k in range(0, n - m + 1):
            new_str = str_lst[k: k + m]
            if new_str == new_str[::-1]:
                print(f'#{tc} {"".join(new_str)}')