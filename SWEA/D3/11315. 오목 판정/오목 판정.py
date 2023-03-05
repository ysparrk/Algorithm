# 1
# 오목 함수
def omok(stone):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            for di, dj in ((-1, 1), (0, 1), (1, 1), (1, 0)):
                for mul in range(5):  # 5개가 쌓이는지 확인
                    ni, nj = i + di * mul, j + dj * mul
                    if stone[ni][nj] != 'o':  # o가 아닌게 나오면 break하고 다음 넘어가기
                        break
                else:
                    return 'YES'
    return 'NO'   # yes가 return되지 않았다면 no

# 2
T = int(input())

for tc in range(1, T + 1):

    n = int(input())  # 문자열 길이
    stone = ['.' * (n + 2)] + ['.' + input() + '.' for _ in range(n)] + ['.' * (n + 2)]  # '.'으로 두르기
    ans = omok(stone)

    print(f'#{tc} {ans}')