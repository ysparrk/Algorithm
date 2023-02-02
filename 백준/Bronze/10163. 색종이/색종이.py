# input
T = int(input())

total = []

# 1
# 튜플을 box 안에 집어 넣고, 그 box를 total에 모두 모으기
for tc in range(T):
    box = []
    x1, y1, a, b = map(int, input().split())
    x1, y1, x2, y2 = x1, y1, x1 + (a - 1), y1 + (b - 1) 

    # 2
    # 튜플 만들어서 box에 추가
    for x in range(x1, x2 + 1):
        for y in range(y1, y2 + 1):
            box.append((x, y))
    
    total.append(box)

# 3
# 겹치는거 찾아서 빼기
for i in range(len(total)):
    n = i + 1          # 해당 인덱스의 위의 box들을 다 구해야 한다.
    same_box = set()   # 겹치는거 모으는 set / 자동적으로 중복된 값 추가 x
    while n < len(total):
        for t in total[n]:     # total[n]의 튜플이, total[i]에 존재한다면 same_box에 추가
            if t in total[i]:    
                same_box.add(t)
        n += 1
    
    print(len(total[i]) - len(same_box))