# 1. input
N, K = map(int, input().split())  # K: 가르칠 글자
words = [list(input()) for _ in range(N)]
learn = [0] * 26
rlt = 0


# 2. dfs
def dfs(idx, cnt):
    global rlt

    # 1) cnt가 K가 되었을때(다 가르쳤을 때) -> 읽을 수 있는 단어 개수 최댓값 확인
    if cnt == K:
        temp = 0
        for word in words:
            flag = True  # 다 배웠는지 확인
            for w in word:
                # 배우지 않은 글자가 있으면 -> break
                if learn[ord(w) - 97] == 0:
                    flag = False
                    break
            if flag:
                temp += 1

        rlt = max(rlt, temp)
        return


    # 2) learn의 글자 하나씩 배우게 하기 -> dfs
    for i in range(idx, 26):
        if learn[i] == 0:
            learn[i] = 1
            dfs(i, cnt + 1)
            learn[i] = 0


# 3. result
if K < 5:
    print(0)
elif K == 26:
    print(N)
else:
    # a, c, i, n, t는 무조건 배우기
    for c in ("a", "c", "i", "n", "t"):
        learn[ord(c) - ord("a")] = 1
    dfs(0, 5)

    print(rlt)