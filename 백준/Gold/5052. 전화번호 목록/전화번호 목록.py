# 0. import
import sys
input = sys.stdin.readline

# 1. input
t = int(input())

# 2. result
for _ in range(t):
    n = int(input()) # 전화번호의 수

    phone = [str(input().strip()) for _ in range(n)]  # 문자열로 받기
    phone.sort()

    flag = True
    for i in range(len(phone) - 1):
        if phone[i] == phone[i + 1][:len(phone[i])]:
            flag = False
            break

    if flag:
        print('YES')
    else:
        print('NO')