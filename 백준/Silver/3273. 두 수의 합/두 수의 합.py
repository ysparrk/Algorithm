# 1. input
N = int(input())
array = list(map(int, input().split()))
X = int(input())

# 2. 투포인터
array.sort()
left, right = 0, N - 1

cnt = 0
while left < right:
    tmp = array[left] + array[right]
    if tmp == X:
        cnt += 1
        left += 1
    elif tmp < X:
        left += 1
    else:
        right -= 1

print(cnt)