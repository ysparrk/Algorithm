# 1
# 중위순회 함수
def in_order(i):
    if i != 0:
        in_order(cL[i])
        print(word[i], end='')  # print 할 때, 노드의 번호에 맞는 word의 인덱스 값 출력
        in_order(cR[i])


T = 10

for tc in range(1, T + 1):

    # 2.  input
    V = int(input())  # 노드 수
    E = V - 1  # 간선 수
    edge = []  # 부모-자식 이어진 리스트
    word = [0] # word 넣는 리스트

    # 3.
    # 1) 1 W 2 3과 같은 리스트를 받고, 문자는 pop해서 word에 담기
    # 2) 부모 노드와 자식 노드를 연달아 edge에 append
    for _ in range(V):
        lst = list(map(str, input().split()))
        word.append(lst.pop(1))  # 문자 pop

        if len(lst) > 1:
            for i in range(1, len(lst)):
                edge.append(int(lst[0]))  # 부모 노드는 고정
                edge.append(int(lst[i]))
        else:  # 자식 노드가 없을 경우, 그 값만 append
            edge.append(int(lst[0]))

    # 4.
    # 부모 인덱스로 자식 번호 저장
    par = [x for x in range(V + 1)]   # parent
    cL = [0] * (V + 1)  # child L
    cR = [0] * (V + 1)  # child R

    for i in range(E):
        p, c = edge[i * 2], edge[i * 2 + 1]

        if cL[p] == 0:  # cL이 비어있으면 input, 값이 있으면 cR에 input
            cL[p] = c
        else:
            cR[p] = c

    # 5.
    # root 찾기 : root는 cL과 cR에 존재하지 않는다.
    for n in par:
        if n not in cL and cR:
            node = 1

    print(f'#{tc}', end=' ')
    in_order(node)
    print()