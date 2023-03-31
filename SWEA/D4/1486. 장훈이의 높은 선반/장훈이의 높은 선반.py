# 1
def dfs(x, rlt):
    global minB
    # 1-3 pruning -> 시간이 줄어드는지 확인
    # if rlt <= rlt - b:
    #     return
    # if rlt == 0:  # 이미 만점
    #     return
    
    # 1-1
    if x == n:
        if rlt >= b:
            minB = min(minB, rlt-b)  # 최솟값 갱신
        return

    # 1-2 포함 O, 포함 X
    dfs(x + 1, rlt + s[x])
    dfs(x + 1, rlt)

# 2
T = int(input())

for tc in range(1,  T + 1):

    n, b = map(int, input().split())  # 점원 수, 선반 높이
    s = list(map(int, input().split()))  # 점원 키
    minB = n * 10000 # 최솟값

    dfs(0, 0)

    print(f'#{tc} {minB}')