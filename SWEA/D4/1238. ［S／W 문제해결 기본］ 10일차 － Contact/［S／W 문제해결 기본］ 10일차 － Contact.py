# 1
# bfs
def bfs(c_from, c_to, v, n):
    # 1-1
    visited = [0] * 101
    queue = []
    queue.append(v)
    visited[v] = 1

    # 1-2 visited에 방문한 곳 표시
    while queue:
        t = queue.pop(0)

        for i in range(n//2):
            if not visited[c_to[i]] and c_to[i] != 0 and c_from[i] == t: # 방문 x, to의 값 0 x, from의 값이 pop한 값과 같아야 한다. 
                queue.append(c_to[i])  # 해당 idx에서 to의 값을 queue에 삽입
                visited[c_to[i]] = visited[t] + 1  # 방문한곳 visited

                for j in range(n//2):  # 전화를 건 번호가 c_to에 있다면 초기화
                    if c_to[j] == t:
                        c_to[j] = 0

    # 1-3
    # return => visited에서 가장 숫자가 높은 idx 중 max idx
    rlt = max(visited)
    ans = 0
    for i in range(101):
        if visited[i] == rlt and i > ans:
            ans = i

    return ans


T = 10

# 2
# {from, to}를 분리하여 각각의 리스트를 만든다.
for tc in range(1, T + 1):
    n, v = map(int, input().split())  # 데이터 길이, 시작점
    contact = list(map(int, input().split()))
    c_from = contact[0::2]  # from 슬라이싱
    c_to = contact[1::2] # to 슬라이싱

    print(f'#{tc} {bfs(c_from, c_to, v, n)}')