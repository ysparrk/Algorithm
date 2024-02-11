# 1. input
N, M, K = map(int, input().split())  # 도시, 케이블 수, 발전소 개수
bal = list(map(int, input().split()))  # 발전소가 설치된 도시 번호


# 2. Kruskal Algorithm
edges = []
for _ in range(M):
    u, v, w = map(int, input().split())
    edges.append((u, v, w))

edges.sort(key=lambda x: x[2])  # 가중치가 작은 것 부터 정렬


# 3. Union-Find
parent = [x for x in range(N+1)]  # 본인 노드로 초기화

for x in bal:
    parent[x] = 0  # 발전소의 부모를 0으로 통일

# 1) 루트 노드 찾기
def find_parent(x):
    if parent[x] != x:
        parent[x] = find_parent(parent[x])

    return parent[x]


# 2) 합치기
def union_parent(a, b):
    a = find_parent(a)
    b = find_parent(b)

    # 부모 노드 지정
    if a < b:
        parent[b] = a

    else:
        parent[a] = b


# 3) 사이클 여부 확인
def same_parent(a, b):
    return find_parent(a) == find_parent(b)


# 4. result
rlt = 0
for a, b, c in edges:
    if not same_parent(a, b):
        union_parent(a, b)  # 집합 합치기
        rlt += c

print(rlt)