# 1
# 순열 생성 + baby gin 확인
def perm(i, k):  # k : 원소의 개수, i : 값을 결정할 자리
    global rlt
    if i == k:
        p1 = p[:3] # 슬라이싱 -> tri, run 확인
        p2 = p[3:]
        if babygin(p1) == babygin(p2) == True:  # 모두 True라면 rlt + 1
            rlt += 1

    else:
        for j in range(i, k):
            p[i], p[j] = p[j], p[i]
            perm(i + 1, k)
            p[i], p[j] = p[j], p[i]

# 2
# triplet, run 확인 -> return True
def babygin(p):

    if p[0] == p[1] == p[2]:
        return True
    elif p[0] - p[1] == 1 and p[1] - p[2] == 1:
        return True
    elif p[0] - p[1] == -1 and p[1] - p[2] == -1:
        return True

# 3
T = int(input())

for tc in range(T):

    p = list(map(int, input()))
    rlt = 0
    perm(0, 6) # 함수 실행

    if rlt >= 1:
        print("True")
    else:
        print("False")