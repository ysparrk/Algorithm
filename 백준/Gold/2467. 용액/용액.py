# 0. import
import sys
INF = sys.maxsize

# 1. input
N = int(input())
liquid = list(map(int, input().split()))

# 2. two pointer
# sum>0 right를 줄임  / sum<0 left를 줄임 / sum=0 정답
left = 0
right = N-1
cur_rlt = INF
left_rlt, right_rlt = left, right
while left < right:
    temp = liquid[left] + liquid[right]

    # 절댓값이 현재 보다 작으면 -> 값 바꾸기
    if abs(temp) < cur_rlt:
        cur_rlt = abs(temp)
        left_rlt, right_rlt = left, right

        if temp == 0:
            break

    if temp > 0:
        right -= 1
    else:
        left += 1


print(liquid[left_rlt], liquid[right_rlt])