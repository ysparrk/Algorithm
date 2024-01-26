# 0. import
import sys
from collections import deque
input = sys.stdin.readline

# 1. input
N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]

for _ in range(M):
    v, e = map(int, input().split())
    graph[v].append(e)
    graph[e].append(v)

# 1) graph 노드 정렬
for i in range(1, N+1):
    graph[i].sort()


# 2. BFS
def bfs(start, end):

    q = deque([(start, [start])])
    visited[start] = 1

    while q:
        v, path = q.popleft()  # 시작점, 경로

        if v == end:
            return path

        for i in graph[v]:
            if not visited[i]:
                q.append((i, path+[i]))
                visited[i] = 1


# 3. result
S, E = map(int, input().split())

# 1) S -> E
visited = [0 for _ in range(N+1)]
path1 = bfs(S, E)

# 2) E -> S
visited = [0 for _ in range(N+1)]
for x in path1:
    visited[x] = 1

visited[S] = 0
path2 = bfs(E, S)

print(len(path1) + len(path2) - 2)