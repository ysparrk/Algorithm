import random
                                    
height_list = []
# while True:
#     height = input()
#     if height == '':
#         break
#     height_list.append(height)

for i in range(9):
    height_list.append(int(input()))


while True:
    height_sample = random.sample(height_list, 7)
    if sum(height_sample) != 100:
        continue
    else:
        height_sample.sort()
        for i in height_sample:
            print(i)
        break