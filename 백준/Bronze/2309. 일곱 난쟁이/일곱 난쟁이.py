import random
                                    
height_list = []
# 1
# input 받아서 height_list에 추가
for i in range(9):
    height_list.append(int(input()))

# 2
# random.sample 이용해 랜덤으로 7개 요소 담은 리스트 출력
# while문으로 height_sample의 합이 100이 아니면 continue로 위로 돌아가 다시 random 리스트 출력
# height_sample의 합이 100이면 오름차순 정렬하고 하나씩 출력, + break로 종료.
while True:
    height_sample = random.sample(height_list, 7)
    if sum(height_sample) != 100:
        continue
    else:
        height_sample.sort()
        for i in height_sample:
            print(i)
        break