# 1. input
T = int(input())

# 2.
for _ in range(T):
    N = int(input())
    tree = [0] * (N+1)

    for _ in range(N-1):
        a, b = map(int, input().split())  # 부모, 자식
        tree[b] = a

    node1, node2 = map(int, input().split())
    node1_p, node2_p = [0, node1], [0, node2]

    while tree[node1]:
        node1_p.append(tree[node1])
        node1 = tree[node1]

    while tree[node2]:
        node2_p.append(tree[node2])
        node2 = tree[node2]

    i = 1
    while node1_p[-i] == node2_p[-i]:
        i += 1

    print(node1_p[-i + 1])