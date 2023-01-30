# 1
# (x, y) 넣을 리스트 선언
# (0, 0) ~ (99, 99)의 박스 100개로 이루어져 있다고 생각한다.
# 리스트에 튜플을 넣을 예정
box = []

# 2
# 변수 받기(4번)
for _ in range(4):
    # 변수 받음
    x1, y1, x2, y2 = map(int, input().split())
    # (0,0) 부터 시작이므로 x2, y2에서 각각 -1
    x1, y1, x2, y2 = x1, y1, x2 - 1, y2 - 1

    # 튜플 만들어서 box에 추가
    for i in range(x1, x2 + 1):
        for y in range(y1, y2 + 1):
            box.append((i, y))
# 3
# 만들어진 리스트에서 중복값 제거
# 최종 리스트 길이 => 박스 갯수           
new_box = []
for i in box:
    if i not in new_box:
        new_box.append(i)

print(len(new_box))
