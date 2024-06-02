import sys
sys.setrecursionlimit(10**8)


# 0. setting
state = ['d', 'l', 'r', 'u']  # 사전 순으로 시작
dx = [1, 0, 0, -1]
dy = [0, -1, 1, 0]
rlt = 'z'


def solution(n, m, x, y, r, c, k):
    
    # 1. 불가능 조건
    def impossible(nx, ny, cnt):
        dist = abs(nx - r) + abs(ny - c)
        if dist > (k - cnt) or (k - cnt - dist) % 2 == 1:
            return True
        
        return False
    
    
    # 2. dfs
    def dfs(nx, ny, ns, cnt):
        global rlt
        
        # 종료조건 1
        if abs(nx - r) + abs(ny - c) + cnt > k:
            return
        
        
        # 종료조건 2 / E에 도착 시
        if nx == r and ny == c:
            if impossible(nx, ny, cnt):
                return
            
            if cnt == k:
                rlt = ns
                return


        # keeping
        for z in range(4):
            kx, ky = nx + dx[z], ny + dy[z]  # 다음지점
            
            if 1 <= kx <= n and 1 <= ky <= m and ns < rlt:  # 범위 안, 사전순 -> 이동    
                dfs(kx, ky, ns + state[z], cnt + 1)
    
    
    # 3. result
    
    # 1) 불가능 확인
    if impossible(x, y, 0):
        return "impossible"
        
    # 2) 결과
    dfs(x, y, '', 0)

    
    return rlt