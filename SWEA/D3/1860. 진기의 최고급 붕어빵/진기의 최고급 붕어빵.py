# 1
# 손님이 올때 붕어빵이 있는지 확인하는 함수
def bungbung():
    rlt = 0
    for i in range(len(bungeo)):
        rlt += bungeo[i]             # 붕어를 더하고
        for j in customer:
            if i == j and rlt >= 1:  # 손님이 올때
                rlt -= 1             # 붕어 하나 제거
            elif i == j and rlt < 1:
                return 'Impossible'
    else:
        return 'Possible'

# 2
T = int(input())

for tc in range(1, T + 1):
    # 2-1. input
    n, m, k = map(int, input().split())  # 손님, 초, k개
    customer = list(map(int, input().split()))  # 손님 도착 시간
    customer.sort()
    bungeo = [0] * (max(customer) + 1) # 초에 따른 붕어 개수 들어있는 리스트(idx->초)

    # 2-2
    # 붕어 만들기(m초에 시작해서 m초 마다 건너뛴다)
    for i in range(m, len(bungeo), m):
        bungeo[i] += k

    print(f'#{tc} {bungbung()}')