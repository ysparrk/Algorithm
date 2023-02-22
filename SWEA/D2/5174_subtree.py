

# 1. 전위 함수
# i에 들어오는 값이 전체의 root가 아니라 subtree의 root가 들어온다.
def pre_order(i):
    global cnt
    if i > 0:
        cnt += 1  # return을 하게 되면 cnt +1
        pre_order(cL[i])
        pre_order(cR[i])
    return cnt  # 최종 cnt return

# 2
T = int(input())

for tc in range(1, T + 1):
    # 2-1
    # input
    E, N = map(int, input().split())  # 간선 수, N
    V = E + 1 # 노드 수
    edge = list(map(int, input().split()))
    par = [x for x in range(V + 1)]  # parent
    cL = [0] * (V + 1)  # child L
    cR = [0] * (V + 1)  # child R
    cnt = 0 # cnt

    # 2-2
    for i in range(E):
        p, c = edge[i * 2], edge[i * 2 + 1]

        if cL[p] == 0:  # cL이 비어있으면 input, 값이 있으면 cR에 input
            cL[p] = c
        else:
            cR[p] = c

    print(f'#{tc} {pre_order(N)}')



