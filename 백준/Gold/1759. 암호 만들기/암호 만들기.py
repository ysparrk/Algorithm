# 0. import
import sys
input = sys.stdin.readline

# 1. input
L, C = map(int, input().split()) # 암호 길이, 가능성 있는 문자 개수
c_lst = list((input().split()))
words = [ord(x) for x in c_lst]  # 아스키 코드 변환

# 2. Backtracking
moeum = [97, 101, 105, 111, 117]  # 모음
rlt = []
# 1) 모음, 자음 개수 확인
def is_possible(word):
    intersection = list(set(word) & set(moeum))  # 교집합
    l = len(intersection)
    if l == 0:
        return False
    elif L - l >= 2:
        return True

# 2) 백트래킹
def make_word(word):

    if len(word) == L:
        if is_possible(word) == True:
            change_to_word = [chr(x) for x in word]
            final = ''
            for c in change_to_word:
                final += c
            rlt.append(final)

    else:
        for w in words:
            # 중복 X, 알파벳 순서대로
            if w not in word and (word == [] or word[-1] < w):
                word.append(w)
                make_word(word)
                word.pop()

make_word([])

# 3) 사전순으로 정렬 -> print
rlt_sort = sorted(rlt)
for r in rlt_sort:
    print(r)
