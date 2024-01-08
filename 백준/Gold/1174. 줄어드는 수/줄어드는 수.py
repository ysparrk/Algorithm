# 1. input
N = int(input())

numbers = set()  # 결과
temp = [] # 숫자 쌓기


# 2. backtracking
def dfs():
    # 1) temp안의 숫자 -> join해서 set에 채우기
    if temp:
        numbers.add(int("".join(map(str, temp))))

    # 2) temp에 아무것도 없거나 i가 마지막 글자보다 작다면 -> temp에 채우기
    for i in range(10):
        if not temp or temp[-1] > i:
            temp.append(i)
            dfs()
            temp.pop()  # 마지막 제거

dfs()


# 3. result
numbers = list(numbers)
numbers.sort()

if len(numbers) >= N:
    print(numbers[N-1])
else:
    print(-1)