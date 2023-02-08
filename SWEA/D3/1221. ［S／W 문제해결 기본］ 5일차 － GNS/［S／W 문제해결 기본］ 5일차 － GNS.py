T = int(input())

for _ in range(T):
    # 1
    # input
    tc, N = map(str, input().split())  # 테스트 케이스, 문자 수 받기
    nums = list(map(str, input().split()))  # 전체 문자열 리스트로 받기

    # 2
    # 조건에 맞는 딕셔너리 만들기
    planet = {
        0 : 'ZRO', 1 : 'ONE', 2 : 'TWO',
        3 : 'THR', 4 : 'FOR', 5 : 'FIV',
        6 : 'SIX', 7: 'SVN', 8 : 'EGT', 9 : 'NIN'
    }

    # 3
    # for문 돌려서 value값과 같은 key를 찾아서 nums 리스트 변경
    for i in range(len(nums)):
        for key, value in planet.items():
            if nums[i] == value:
                nums[i] = key

    # 4
    # 정렬 + for문 다시 돌려서 문자열로 바꾸기
    nums.sort()
    for i in range(len(nums)):
        for key, value in planet.items():
            if nums[i] == key:
                nums[i] = value

    print(f'{tc}')
    print(' '.join(nums))