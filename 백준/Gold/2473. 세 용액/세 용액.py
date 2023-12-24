# 0. import
import sys
INF = sys.maxsize

# 1. input
N = int(input())
liquid = list(map(int, input().split()))
liquid.sort()


# 2. two pointer
cur_rlt = INF
fix_rlt, left_rlt, right_rlt = 0, 1, N-1
for i in range(N-2):
    fix = i     # 고정값
    left = i+1
    right = N-1

    # 1) 고정된 값에 대해 투포인터 적용
    while left < right:
        temp = liquid[fix] + liquid[left] + liquid[right]

        # 2) 절댓값이 현재 보다 작으면 -> 값 바꾸기
        if abs(temp) < cur_rlt:
            cur_rlt = abs(temp)
            fix_rlt, left_rlt, right_rlt = fix, left, right

            if temp == 0:
                break

        if temp > 0:
            right -= 1
        else:
            left += 1


print(liquid[fix_rlt], liquid[left_rlt], liquid[right_rlt])