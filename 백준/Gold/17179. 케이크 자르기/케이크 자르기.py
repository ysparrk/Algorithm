# 1. input
n, m, l = map(int, input().split())
s_list = [0] + [int(input()) for _ in range(m)] + [l]


# 2. 가장 작은 조각의 길이의 최댓값
def find_min(q):
    start, end = 1, l
    rlt = 0

    while start <= end:
        mid = (start + end) // 2
        
        # 1) 자르는 count
        cnt, temp = 0, 0
        for s in s_list:
            if s - temp >= mid:
                cnt += 1
                temp = s

        if cnt > q:
            start = mid + 1
            rlt = max(rlt, mid)
        else:
            end = mid - 1

    return rlt


# 3. q input
for _ in range(n):
    q = int(input())
    print(find_min(q))