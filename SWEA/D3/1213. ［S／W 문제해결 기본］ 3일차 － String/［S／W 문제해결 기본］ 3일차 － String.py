# 1
# 함수 선언
def bf(tar, sen):
    i = 0  # sen의 idx
    cnt = 0
    while i <= n - m:  # out of range 주의
        if i <= n - m and sen[i : i + m] == tar:
            cnt += 1
            i += m
        else:
            i += 1
    return cnt

# 2
T = 10
for _ in range(1, T + 1):
    tc = int(input())
    tar = input()
    sen = input()

    n = len(sen)
    m = len(tar)

    print(f'#{tc} {bf(tar, sen)}')