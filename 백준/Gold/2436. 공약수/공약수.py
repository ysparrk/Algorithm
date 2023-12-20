# 1. input
gcd, lcm = map(int, input().split())


# 2. 서로소 확인
def coprime(x, y):
    while y > 0:
        x, y = y, x % y

    if x == 1:
        return True
    
    return False


# 3. result
# a*b -> a+b 가장 작은 것(a, b는 서로소)
div = lcm // gcd
a, b = 1, div  # 초기값

for i in range(1, div//2 + 1):
    # 1) 나눠지는지 확인
    if div % i == 0:
        temp_a, temp_b = i, div // i 

        # 2) 서로소 확인
        if coprime(temp_a, temp_b):
            if a+b > temp_a + temp_b:
                a, b = temp_a, temp_b

print(a*gcd, b*gcd)