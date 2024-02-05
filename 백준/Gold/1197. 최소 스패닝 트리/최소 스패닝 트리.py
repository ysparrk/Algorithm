# 1. input
V, E = map(int, input().split())


# 2. Kruskal Algorithm
edges = []
for _ in range(E):
    A, B, C = map(int, input().split())
    edges.append((A, B, C))

edges.sort(key=lambda x: x[2])  # 가중치가 작은 것 부터 정렬


# 3. Union-Find
parent = [x for x in range(V+1)]

# 1) 특정 원소가 속한 집합 찾기
def find_parent(x):
    if parent[x] == x:
        return x
    parent[x] = find_parent(parent[x])
    return parent[x]


# 2) 두 원소가 속한 집합 합치기
def union_parent(a, b):
    a = find_parent(a)
    b = find_parent(b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b
        

# 3) 사이클 확인 -> 같은 부모를 공유하지 않으면 사이클 X
def same_parent(a, b):
    return find_parent(a) == find_parent(b)


# 4. result
# 사이클 X -> 추가
rlt = 0
for a, b, c in edges:
    if not same_parent(a, b):
        union_parent(a, b)  # 집합 합치기
        rlt += c

print(rlt)