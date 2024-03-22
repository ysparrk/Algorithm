# 1. input
N, C = map(int, input().split())
nums = list(map(int, input().split()))
dict = {}


# 2. sort
for i in range(N):
    if dict.get(nums[i]):
        dict[nums[i]] += 1
    else:
        dict[nums[i]] = 1

d = sorted(dict.items(), key=lambda x: x[1], reverse=True)


# 3. rlt
rlt = ''
for i in range(len(d)):
    rlt += (str(d[i][0]) + ' ') * d[i][1]

print(rlt)