# 1. input
A, B = map(int, input().split())


# 2. result
cnt = 1
while B != A:
    cnt += 1
    tmp = B

    if B % 10 == 1:
        B //= 10
    elif B % 2 == 0:
        B //= 2

    if tmp == B:
        print(-1)
        break

else:
    print(cnt)