# 1
def dfs(x, rlt):
    global ans

    # 1-3 pruning
    if rlt > ans:
        return

    # 1-1
    if x >= 12:
        ans = min(ans, rlt)
        return
    # 1-2
    else:
        dfs(x+1, rlt + plan[x] * day)  # day
        dfs(x+1, rlt + m1)  # 1 month
        dfs(x + 3, rlt + m3) # 3 month
        dfs(x + 12, rlt + year) # year

# 2
T = int(input())

for tc in range(1, T + 1):

    day, m1, m3, year = map(int, input().split())  # 이용 요금

    plan = list(map(int, input().split()))

    ans = 365*day

    dfs(0, 0)

    print(f'#{tc} {ans}')