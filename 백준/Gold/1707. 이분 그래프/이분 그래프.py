# 0. import
import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

# 1. input
K = int(input())


# 3. dfs
def dfs(start, visited, temp):

    visited[start] = temp

    for g in graph[start]:
        if visited[g] == 0:
            visited[g] = -temp
            if dfs(g, visited, -temp) != True:
                return False

        else:
            if visited[g] == temp:
                return False

    return True


# 2. graph 만들기
for _ in range(K):
    V, E = map(int, input().split())  # 정점 개수, 간선 개수
    graph = [[] for _ in range(V+1)]
    visited = [0] * (V+1)
    for _ in range(E):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)


    # 4. dfs
    # 인접하면 -> 다른 숫자로 채우기
    for i in range(1, V+1):
        if visited[i] == 0:
            if dfs(i, visited, 1):
                continue

            else:
                print("NO")
                break
    else:
        print("YES")