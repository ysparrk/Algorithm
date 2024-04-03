# 0. import
import sys
input = sys.stdin.readline
INF = sys.maxsize


# 1. input
N, M = map(int, input().split())
edges = []  # 모든 간선 정보
dist = [INF] * (N + 1)  # 최단 거리

for _ in range(M):
    A, B, C = map(int, input().split())  # A -> B, C: cost
    edges.append((A, B, C))


# 2. 벨만-포드
def bellam_ford(start):
    # 1) 시작 노드에 대해 초기화
    dist[start] = 0

    # 2) 전체 N-1번의 라운드 반복
    for i in range(N):
        # 모든 간선 확인
        for j in range(M):
            cur_node, next_node, edge_cost = edges[j]

            # 3) 최단거리 갱신
            if dist[cur_node] != INF and dist[next_node] > dist[cur_node] + edge_cost:
                dist[next_node] = dist[cur_node] + edge_cost

                # 4) N번째 라운드에서도 값이 갱신된다면, 음수 간선 순환이 존재
                if i == N - 1:
                    return True

    return False


# 3. result
if bellam_ford(1):
    print(-1)
else:
    # 최단거리 출력
    for i in range(2, N + 1):
        if dist[i] == INF:  # 도달X
            print(-1)
        else:
            print(dist[i])