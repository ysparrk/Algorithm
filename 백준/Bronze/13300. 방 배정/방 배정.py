# input
# 전체 학생 수, 방 최대 인원
num, max = map(int, input().split())  

# 1
# 튜플로 받아야 딕셔너리에 key값으로 들어간다.
student = [tuple(map(int, input().split())) for _ in range(num)] 

#2
# 튜플이 key, count값이 value인 딕셔너리
# 방이 될 튜플을 담을 리스트
room_list = {}
new_room = []

# 3
# 같은 튜플을 가진 것 끼리 묶어 count
for i in student:
    try: room_list[i] += 1
    except: room_list[i] = 1

# 4
# 방의 최대 인원에 맞는지 확인하고, 최대 인원을 넘는다면 (최대인원/몫 + 1)번 만큼 요소를 new_room에 넣는다.
for value in room_list.values():
    if value <= max:
        new_room.append(value)
    elif value > max:
        t = 1
        while t <= (value // max + 1):
            new_room.append(2)
            t += 1

print(len(new_room))