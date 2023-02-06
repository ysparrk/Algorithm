'''
1~12까지의 숫자를 원소로 가진 집합 A
N개의 원소를 갖고 있고, 원소의 합이 K인 부분집합의 개수
부분집합이 없는 경우 0을 출력.
'''

T = int(input())

for tc in range(1, T + 1):
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
    n, k = map(int, input().split())
    # 1
    total = []  # arr의 모든 부분집합이 리스트 형태로 담길 리스트
    result = [] # 조건을 만족하는 부분집합이 담길 리스트

    # 2
    # arr의 모든 부분 집합 구하기 / 리스트 형태로
    for i in range(1 << len(arr)):
        subset = []
        for j in range(len(arr)):
            if i & (1 << j):
                subset.append(arr[j])
        total.append(subset)

    # 3
    # 조건 : n개의 원소, 원소의 합이 k인 부분집합을 모으기
    # 최종적으로 모은 리스트의 길이가 조건을 만족하는 부분집합 개수수
    for i in total:
        if len(i) == n and sum(i) == k:
            result.append(i)

    print(f'#{tc} {len(result)}')


