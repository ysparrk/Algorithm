# 1. input
str = input()


# 2. 인덱스 k의 위치까지의 K의 개수
left_k = []
right_k = []
cnt = 0
for k in str:
    if k == 'K':
        cnt += 1
    else:
        left_k.append(cnt)

cnt = 0
for k in str[::-1]:
    if k == 'K':
        cnt += 1
    else:
        right_k.append(cnt)
right_k.reverse()


# 3. two pointer
left, right = 0, len(left_k) - 1
rlt = 0
while left <= right:
    rlt = max(rlt, right - left + 1 + (2 * min(left_k[left], right_k[right])))

    if left_k[left] < right_k[right]:  # right에 K가 더 많으면,
        left += 1
    else:
        right -= 1

print(rlt)