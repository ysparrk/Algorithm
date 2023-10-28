# 1. input
n = int(input())
x, y = input().split("*")


# 2.
for _ in range(n):
    file = input()

    if len(file) < len(x) + len(y):
        print("NE")

    elif file[:len(x)] == x and file[-len(y):] == y:
        print("DA")

    else:
        print("NE")