# 0. input
import sys
input = sys.stdin.readline

# 1. input
S = input()
space = int(input())
alpha = list(map(int, input().split()))
i = 0


# 2. alpha에서 감소 시킬 수 있는지 확인
def check_alpha(s, m):
    idx = ord(s.upper()) - 65

    alpha[idx] -= m
    if alpha[idx] >= 0:
        return True

    return False


# 3. 중복 문자 제거
def dual_click(s):
    global i

    while S[i] == s and i < len(S) - 1:
        i += 1


# 4. result
def sol():
    global space, i

    rlt = ''
    # 1) 첫번째 글자 체크
    if check_alpha(S[0], 2):
        dual_click(S[0])
        rlt += S[0].upper()
    else:
        return -1

    while i < len(S) - 1:
        # 2) 빈칸 제거
        if S[i] == ' ':
            space -= 1
            if space < 0:
                return -1

            dual_click(S[i])  # 빈칸 중복 제거

            #2-1) 대문자 더하기
            if check_alpha(S[i], 2):
                rlt += S[i].upper()
                dual_click(S[i])
            else:
                return -1

        # 3) 빈칸 X, 대문자 X -> 글자 넘기기
        else:
            if check_alpha(S[i], 1):
                dual_click(S[i])
            else:
                return -1

    return rlt

print(sol())