# 1. input
n, c = map(int,input().split())
home = [int(input()) for i in range(n)]
home.sort()

# 2. Binary Search
start, end = 1, home[n - 1] - home[0]
rlt = 0

if c == 2:
    # 집이 2개
    print(home[n - 1] - home[0])
else:
    while(start < end):
        mid = (start + end) // 2
        cnt = 1
        gongyou = home[0]

        for i in range(n):
            if home[i] - gongyou >= mid:
                cnt += 1
                gongyou = home[i]
                
        if cnt >= c:
            rlt = mid
            start = mid + 1
        elif cnt < c:
            end = mid
    print(rlt)