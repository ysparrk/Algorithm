# 1
def dfs(x, rlt):
    global cnt
    # 1) 종료 조건
    if x == n:
        if rlt == k:
            cnt += 1
        return

    # 2) 하부 호출
    dfs(x + 1, rlt + a[x]) # 포함
    dfs(x + 1, rlt)        # 포함 x


# 2
T = int(input())

for tc in range(1, T + 1):

    n, k = map(int, input().split())
    a = list(map(int, input().split()))  # 수열
    cnt = 0
    
    dfs(0, 0)

    print(f'#{tc} {cnt}')