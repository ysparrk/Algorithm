# k 순열 생성
def perm(i, k):
    if i == k:
        t = p[:]
        k_key.append(t)

    else:
        for j in range(i, k):
            p[i], p[j] = p[j], p[i]
            perm(i + 1, k)
            p[i], p[j] = p[j], p[i]


# 배열의 최솟값 출력하기
def arr_min(arr):

    rlt = 999999999
    for i in range(n):
        ans = 0
        for j in range(m):
            ans += arr[i][j]
        rlt = min(ans, rlt)

    return rlt

# 회전연산 -> 한번 회전
def turn(r, c, s, arr):

    for n in range(s, 0, -1):
        tmp = arr[r-n][c+n]
        arr[r-n][c-n+1:c+n+1] = arr[r-n][c-n:c+n]

        for col in range(r-n, r+n):
            arr[col][c-n] = arr[col+1][c-n]
        arr[r+n][c-n:c+n] = arr[r+n][c-n+1:c+n+1]

        for col in range(r+n, r-n, -1):
            arr[col][c+n] = arr[col-1][c+n]

        arr[r-n+1][c+n] = tmp
    return arr


# 2
n, m, k = map(int, input().split())  # 크기, 회전 연산의 개수


arr_main = [list(map(int, input().split())) for _ in range(n)]

p = [x for x in range(k)]
k_key = []
k_value = [list(map(int, input().split())) for _ in range(k)]  # 순열 만들기

perm(0, k)  # k_key 만들었다

mins = []
for i in range(len(k_key)):
    arr = [x[:] for x in arr_main]  # deepcopy
    for j in range(k):

        r, c, s = k_value[k_key[i][j]][0] - 1, k_value[k_key[i][j]][1] -1, k_value[k_key[i][j]][2]

        arr = turn(r, c, s, arr)

    mins.append(arr_min(arr))

print(min(mins))