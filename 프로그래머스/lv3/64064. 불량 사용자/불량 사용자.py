# 1. user_id == banned_id check
def check(user, banned):
    if len(user) != len(banned):
        return False
    else:
        for i in range(len(user)):
            if banned[i] == '*':
                pass
            elif user[i] != banned[i]:
                return False  
    return True

# 2. DFS
# node의 경로를 stack에 담는다 -> 중복의 경우 set으로 처리
def dfs(sub, v, visited, stack):    
    if v == len(sub):
        stack.add(tuple(visited))
        return
    
    for i in sub[v]:
        if not visited[i]:
            visited[i] = 1
            dfs(sub, v + 1, visited, stack)
            visited[i] = 0
        else:
            continue
                 
# 3.
def solution(user_id, banned_id):
    # 1) sub 만들기
    sub = []
    for i in range(len(banned_id)):
        temp = []
        for j in range(len(user_id)):
            if check(user_id[j], banned_id[i]):
                temp.append(j)
        sub.append(temp)

    # 2) dfs
    stack = set()
    visited = [0] * len(user_id)
    dfs(sub, 0, visited, stack)
    ans = len(stack)
    return ans