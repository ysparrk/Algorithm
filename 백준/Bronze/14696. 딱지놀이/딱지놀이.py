# input
T = int(input())

for tc in range(T):
    # 1
    # a, b리스트 받기
    alist = list(map(int, input().split()))
    blist = list(map(int, input().split()))

    # 2
    # a, b 값 얻기, +리스트에서 지우기
    a = alist[0]
    b = blist[0]

    del alist[0]
    del blist[0]
    
    # 3
    # 리스트 sort
    acount = [0] * 5
    for i in range(0, len(alist)):
        acount[alist[i]] += 1

    bcount = [0] * 5
    for i in range(0, len(blist)):
        bcount[blist[i]] += 1

    # 4
    # 역순으로 같은 인덱스인 값 비교
    for i in range(4, -1, -1):
        if acount[i] != bcount[i]:
            if acount[i] > bcount[i]:
                print('A')
            else:
                print('B')
            break
        else:
            continue

    if acount == bcount:
        print('D')