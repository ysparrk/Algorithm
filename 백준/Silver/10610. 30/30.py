# 1. input
N = input()

# 2.
total = 0
flag = False

rlt = []
for n in N:
    if int(n) == 0:
        flag = True
    rlt.append(n)
    total += int(n)


# 3. result
rlt.sort(reverse=True)
if flag and total % 3 == 0:
    print(*rlt, sep='')
else:
    print(-1)