

import sys
sys.stdin = open("sample_input_노드.txt")


T = int(input())

for tc in range(1, T + 1):
    # 1 초기 설정
    n, m, l = map(int, input().split())  # 노드 개수, 리프노드 개수, 출력할 노드 번호

    tree = [0] * (n + 1)
    left = [0] * (n + 1)
    right = [0] * (n + 1)

    # 2
    # 리프 노드 받기 => 트리에 저장
    for i in range(m):
        node, nums = map(int, input().split())
        tree[node] = nums

    # 3
    # 자식노드의 인덱스로 부모노드의 값 구하기
    for i in range(n, 0, -1):
        if i // 2 > 0:
            tree[i // 2] += tree[i] # 부모의 인덱스에 값 더하기

    print(f'#{tc} {tree[l]}')


