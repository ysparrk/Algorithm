# 1. 초기설정
n = int(input())
col = {}
for _ in range(n):
    l, h = map(int, input().split())
    col[l] = h
col1 = sorted(col.items())


left = col1[0][0]
right = col1[-1][0]
maxV = max(col.values())
maximum = 0

for key, value in col.items():
    if value == maxV:
        maximum = key

max_idx = col1.index((maximum, maxV))

# 2.
h = col1[0][1]
height = [h]

if n >= 2 and col1[-1][1] == maxV:
    height.append(col1[-1][1])

j = 1
for i in range(left + 1, maximum + 1):
    if col1[j][0] < right and col1[j][0] == i:
        if col1[j][1] >= h:                      
            h = col1[j][1]
            height.append(h)
            j += 1
        else:                               
            height.append(h)
            j += 1
    elif col1[j][0] < right or i < right:
        height.append(h)

h = col1[-1][1]
j = n - 1
for i in range(right, maximum, -1):
    if col1[j][0] == i:
        if col1[j][1] >= h:
            h = col1[j][1]
            height.append(h)
            j -= 1
        else:
            height.append(h)
            j -= 1
    else:
        height.append(h)

print(sum(height))