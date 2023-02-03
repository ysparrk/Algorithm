T = int(input())
# 2, 3, 5, 7, 11
num = [2, 3, 5, 7, 11]

# 2

for tc in range(1, T + 1):
    N = int(input())
    square = [0] * (5)  # abcde가 담길 리스트 만들기

    # 3
    # num에서 나눠야 할 숫자를 하나하나 가져와서 최대한 나누고, 나머지가 생기면 다른 숫자로 나누기
    for i in range(len(num)):
        s = 0
        while True:
            quo = N // num[i]  # 몫
            rem = N % num[i]   # 나머지

            # 4
            # 나머지가 0이라면, s에 1을 더하고, 몫을 N에 넣는다
            # 나머지가 0이 아니면, while문 종료 => 그 s값은 해당 인덱스에 넣기, for문으로 돌아가기
            if rem == 0:
                s += 1
                N = quo
            else:
                break

        square[i] = s

    print(f'#{tc} {" ".join(map(str, square))}')  # 공백 빼고 출력