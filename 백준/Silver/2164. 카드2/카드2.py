# 0. import
from collections import deque

# 1. input
n = int(input())
nlst = deque([x+1 for x in range(n)])

# 2. result
while len(nlst) > 0:
    if len(nlst) == 1:
        print(nlst[0])
        exit()
    nlst.popleft()
    temp = nlst.popleft()
    nlst.append(temp)

print(nlst[0])