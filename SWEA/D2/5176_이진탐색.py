'''
1~N까지 자연수 이진탐색 트리에 저장
'''


# 1
# 중위순회 함수
def in_order(i, V):
    global rlt
    if i <= V: # 노드의 개수보다 큰 노드 번호 x
        in_order(2 * i, V) # 노드번호가 i인 노드의 왼쪽 자식 노드 번호
        rlt.append(i)  # return 할때, i를 rlt에 넣는다.
        in_order(2 * i + 1, V) # 노드번호가 i인 노드의 오른쪽 자식 노드 번호
    return rlt

# 2
T = int(input())

for tc in range(1, T + 1):

    V = int(input()) # 간선 수
    rlt = [0] # 중위탐색한 결과 리스트

    print(f'#{tc} {in_order(1, V).index(1)} {in_order(1, V).index(V//2)}')









