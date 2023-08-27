# 0. import
import bisect

# 1. input
t = int(input())
n = int(input())
a_lst = list(map(int, input().split()))
m = int(input())
b_lst = list(map(int, input().split()))


# 2. 누적 합
a_sub = []
b_sub = []

for i in range(n):
    a = a_lst[i]
    a_sub.append(a)
    for j in range(i+1, n):
        a += a_lst[j]
        a_sub.append(a)

for i in range(m):
    b = b_lst[i]
    b_sub.append(b)
    for j in range(i+1, m):
        b += b_lst[j]
        b_sub.append(b)


# 3. binary search
a_sub.sort()
b_sub.sort()

answer = 0
for i in range(len(a_sub)):
    x = bisect.bisect_left(b_sub, t-a_sub[i])
    y = bisect.bisect_right(b_sub, t-a_sub[i])
    answer += y-x

print(answer)