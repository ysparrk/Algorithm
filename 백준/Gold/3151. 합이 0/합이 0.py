# 0. import
import sys
input = sys.stdin.readline


# 1. input
N = int(input())
A = list(map(int, input().split()))
A.sort()


# 2. two pointer
rlt = 0
for i in range(N-2):
    left = i + 1
    right = N - 1

    # 1) fix가 i일 때 세 수의 합이 0이 되는 경우 모두 구하기
    while left < right:
        temp = A[i] + A[left] + A[right]  # 세 합

        if temp > 0:
            right -= 1
        elif temp < 0:
            left += 1
        else:
            # 2) left, right를 어떻게 움직일 것인가
            # 2-1) left, right 같을 때
            if A[left] == A[right]:
                n = right - left
                rlt += n*(n+1) // 2  # 등차수열의 합
                break
            else:
                # 2-2) left, right 같은 수가 몇 개 있는지
                cnt_right = 1
                while left < right and A[right] == A[right-1]:
                    right -= 1
                    cnt_right += 1

                cnt_left = 1
                while left < right and A[left] == A[left+1]:
                    left += 1
                    cnt_left += 1

                rlt += cnt_left * cnt_right

                left += 1
                right -= 1

print(rlt)