# 0. import
import sys
input = sys.stdin.readline


# 1. input
N = int(input())
cards = list(map(int, input().split()))


# 2. 누적합
cum_sum = [0] * (N + 1)
cum_sum[1] = cards[0]  # 짝
cum_sum[2] = cards[1]  # 홀
for i in range(3, N + 1):
    cum_sum[i] += cum_sum[i-2] + cards[i - 1]

bottom = cards[-1]

# 3. result
# 원래는 홀idx -> 이렇게만 가는데 중간에 짝수idx의 합으로 바뀜
rlt = 0
for i in range(2, N + 1):

    if i % 2 == 1:
        # 1) 홀수 -> 밑장 값이 내 값임
        tmp = cum_sum[i - 2] + cum_sum[N] - cum_sum[i - 1]

    else:
        # 2) 짝수
        tmp = cum_sum[i - 1] + cum_sum[N] - cum_sum[i - 2] - bottom

    rlt = max(rlt, tmp)

# 4. 홀짝 인덱스 완전히 뒤바뀔 때
rlt = max(rlt, cum_sum[-1])


print(rlt)