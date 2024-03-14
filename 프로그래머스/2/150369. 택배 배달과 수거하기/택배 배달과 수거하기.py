def solution(cap, n, deliveries, pickups):
    
    d_v = check_vertex(deliveries, n, cap)
    p_v = check_vertex(pickups, n, cap)    
    
    # 2. 결과 구하기
    # a, b의 길이가 다른 경우 -> 최대한 
    a, b = len(d_v), len(p_v)
    
    sum = 0
    for i in range(min(a, b)):

        sum += max(d_v[i], p_v[i]) * 2

    if a > b:
        for j in range(b, a):
            sum += d_v[j] * 2
        
        
    elif a < b:    
        for j in range(a, b):
            sum += p_v[j] * 2
    
    return sum


# 1.
# 각 꼭짓점 구하기
def check_vertex(box, n, cap):
    
    vertex = []
    
    i = n - 1
    while i >= 0:
    
        cnt = cap
        if box[i]:
            vertex.append(i + 1)
            
            # cap 만큼 채우기
            while cnt > 0 and i >= 0:

                if box[i] == 0:
                    i -= 1
                else:
                    box[i] -= 1
                    cnt -= 1
        else:
            i -= 1
            
    return vertex
