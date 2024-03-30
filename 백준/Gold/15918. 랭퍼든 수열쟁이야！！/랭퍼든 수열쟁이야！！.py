# 1. input
N, X, Y = map(int, input().split())

arr = [0 for _ in range(2 * N + 1)]
arr[X] = arr[Y] = Y - X - 1  # 조건 배치
rlt = 0  # 결과


# 2. dfs
def dfs(num):
    '''
    0. arr에 num을 배치한다. 1부터 시작
    1. 반환조건 -> num이 N + 1인 경우
    2. 수열 만들기
        - num을 i / i+num+1 자리에 배치
        - 재귀
    '''

    global rlt

    # 1) 반환조건
    if num == N + 1:
        rlt += 1


    # 2) 수열 만들기
    if num == arr[X]:
        dfs(num + 1)
    else:
        for i in range(1, 2 * N + 1):
            # 자리가 비어있으면 -> 배치하기
            if (i + num + 1) <= (2 * N) and arr[i] == 0 and arr[i + num + 1] == 0:
                arr[i] = arr[i + num + 1] = num
                dfs(num + 1)
                arr[i] = arr[i + num + 1] = 0


dfs(1)
print(rlt)