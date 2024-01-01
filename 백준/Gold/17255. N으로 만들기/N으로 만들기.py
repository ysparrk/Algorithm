# 1. input
N = input()
nN = len(N)


# 2. dfs
# temp에 누적해서 문자열 쌓기
def dfs(left, right, temp):
    if len(temp) == end_point:
        rlt.add(temp)
        return

    # 1) 왼쪽에 더하기
    if left > 0:
        dfs(left-1, right, temp + N[left-1:right+1])

    # 2) 오른쪽에 더하기
    if right < nN:
        dfs(left, right+1, temp + N[left:right+2])


# 3. result
end_point = nN * (nN + 1) // 2  # 누적되는 문자열의 최대 길이 -> 도달했을 때 return
rlt = set()
for i in range(nN):
    dfs(i, i, N[i])  # i의 위치에서 시작

print(len(rlt))