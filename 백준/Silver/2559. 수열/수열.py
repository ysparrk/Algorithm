import sys
input = sys.stdin.readline  # 시간 초과 방지

# 1
# 초기 설정
n, k = map(int, input().split())
temp = list(map(int, input().split()))

# 2
temp_sum = sum(temp[0 : k])  # 처음 나오는 sum값
rlt = temp_sum

# 3
# 제일 처음의 sum값에서 인덱스로 가장 처음을 빼고, 범위의 다음 값을 더해서 새로운 합 만들기
# 비교해서 새로운 합이 더 크다면, temp_max로 바꾸기
for i in range(1, n - k + 1):
    temp_sum -= temp[i - 1]  #
    temp_sum += temp[i + (k - 1)]  # temp_sum의 바로 다음
    if rlt < temp_sum:
        rlt = temp_sum

print(rlt)