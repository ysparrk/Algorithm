'''
문자열 뒤집기
python => reverse or slice notation 이용
'''

T = int(input())

for tc in range(1, T + 1):
    str_lst = list(input())  # input
    str_lst = str_lst[::-1]  # slice 이용

    print(f'#{tc} {"".join(str_lst)}')
