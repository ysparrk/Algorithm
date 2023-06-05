# 1. 기울기 계산
def slope(a, b, dots):
    ans = (dots[a][0] - dots[b][0]) / (dots[a][1] - dots[b][1])
    return ans

# 2. result
def solution(dots):
    answer = 0
    
    for i in range(3):
        for j in range(i+1, 4):
            x = -1
            y = -1
            for k in range(4):
                if k != i and k != j:
                    if x == -1:
                        x = k
                    else:
                        y = k
            
            
                        print(i, j, x, y)
                        # 기울기 비교
                        if slope(i, j, dots) == slope(x, y, dots):
                            answer = 1
                            return answer
            
    return answer