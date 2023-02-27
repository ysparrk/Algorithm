'''

입력 순서대로 이진 최소힙에 저장, 마지막 노드의 조상 노드에 저장된 정수의 합

'''



import sys
sys.stdin = open('sample_input.txt')

T = int(input())

for tc in range(1, T + 1):
    # 초기 설정
    v = int(input())
    data = list(map(int, input().split()))
    tree = [0] * (v + 1)
    last = 1  # 시작 정점

    # 2
    # 최소 힙구하기
    for i in range(v):
        if not tree[i]: # 값이 존재하지 않는다면
            tree[last] = data[i] # tree에 값 넣기
        else:  # tree에 값이 존재한다면
            last += 1
            child = last  # 새로 추가된 정점을 자식으로
            parent = child // 2  # 완전 이진 트리에서 부모 정점 번호

            tree[child] = data[i] # tree에 data 추가

            # 2-2
            # 최소힙 조건
            while parent >= 1 and tree[parent] > tree[child]:  # 부모가 작아질 때 까지

                tree[parent], tree[child] = tree[child], tree[parent] # 부모, 자식 위치 변경
                child = parent # 자식
                parent = parent // 2

    # 3
    # 마지막 노드의 조상 노드의 합 구하기
    rlt = 0
    while v > 1:
        v = v // 2
        rlt += tree[v]

    print(f'#{tc} {rlt}')