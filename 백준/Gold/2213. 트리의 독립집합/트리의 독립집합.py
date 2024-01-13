# 0. import
import sys
input = sys.stdin.readline

# 1. input
N = int(input())  # 정점 수
w_lst = [0] + list(map(int, input().split()))  # 가중치

tree = [[] for _ in range(N+1)]

for _ in range(N-1):
    u, v = map(int, input().split())
    tree[u].append(v)
    tree[v].append(u)


# 2. dfs
dp = [[0, 0] for _ in range(N+1)]  # dp[i][0] 독립집합X 누적크기, dp[i][1] 독립집합O 누적크기
paths = [[[], []] for _ in range(N+1)]  # paths[i][0] 독립집합X 경로, paths[i][1] 독립집합O 경로
visited = [0 for _ in range(N+1)]
def dfs(node):

    visited[node] = 1
    dp[node][1] = w_lst[node]  # 가중치 넣기
    paths[node][1].append(node) # 경로 넣기

    for i in tree[node]:
        if visited[i] == 0:
            dfs(i)
            # 1) i가 독립집합이 아닌 경우
            if dp[i][0] > dp[i][1]:
                dp[node][0] += dp[i][0]
                paths[node][0].extend(paths[i][0])
            else:
                dp[node][0] += dp[i][1]
                paths[node][0].extend(paths[i][1])

            # 2) 독립집합이 맞는 경우
            dp[node][1] += dp[i][0]
            paths[node][1] += paths[i][0]

dfs(1)

# 3. result
if dp[1][0] > dp[1][1]:
    paths[1][0].sort()
    print(dp[1][0])
    print(*paths[1][0])
else:
    paths[1][1].sort()
    print(dp[1][1])
    print(*paths[1][1])