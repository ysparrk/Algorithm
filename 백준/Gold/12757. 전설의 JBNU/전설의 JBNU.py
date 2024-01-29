# 0. import
import bisect
import sys
input = sys.stdin.readline


# 1. input
N, M, K = map(int, input().split())
dict = {}
dictKey = []


# 2. BinarySearch
def findKey(target):

    if dict.get(target, -1) != -1:
        return target

    # 1) 이진탐색
    idx = bisect.bisect_left(dictKey, target)


    # 2) 구해진 idx를 가지고 결과 구하기
    if idx == 0:  # 맨앞 or 맨끝
        if abs(dictKey[idx] - target) <= K:
            return dictKey[idx]

    elif idx == len(dictKey):
        if abs(dictKey[idx-1] - target) <= K:
            return dictKey[idx-1]

    else:
        # left, right 중 어느 것이 더 가까운지
        left = target - dictKey[idx-1]
        right = dictKey[idx] - target
        if left == right and left <= K:
            return -2
        if left < right and left <= K:
            return dictKey[idx-1]
        if right < left and right <= K:
            return dictKey[idx]

    return -1

def addKey(key):
    idx = bisect.bisect_left(dictKey, key)
    dictKey.insert(idx, key)


# 3. result
for _ in range(N):
    key, value = map(int, input().split())
    dict[key] = value
    addKey(key)

for _ in range(M):
    mLst = list(map(int, input().split()))

    if mLst[0] == 1:
        dict[mLst[1]] = mLst[2]
        addKey(mLst[1])

    elif mLst[0] == 2:
        keys = findKey(mLst[1])
        if keys >= 0:
            dict[keys] = mLst[2]
            
    else:
        keys = findKey(mLst[1])
        if keys == -2:
            print("?")
        elif keys == -1:
            print(-1)
        else:
            print(dict[keys])