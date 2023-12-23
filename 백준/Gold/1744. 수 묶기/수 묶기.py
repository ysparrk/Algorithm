# 1. input
N = int(input())
nums = [int(input()) for _ in range(N)]


# 2. 양수, 음수 구분
# 1은 바로 결과에 더하기
plus = []
minus = []

rlt = 0
for n in nums:
    if n > 1:
        plus.append(n)
    elif n <= 0:
        minus.append(n)
    else:
        rlt += 1


plus.sort(reverse=True)
minus.sort()


# 3. result
# 1) 양수 묶기
for i in range(0, len(plus), 2):
    if i+1 >= len(plus):
        rlt += plus[i]
    else:
        rlt += (plus[i] * plus[i+1])

# 2) 음수 묶기
for i in range(0, len(minus), 2):
    if i+1 >= len(minus):
        rlt += minus[i]
    else:
        rlt += (minus[i] * minus[i+1])

print(rlt)