'''
str1, str2
str1에 포함된 글자들이 str2에 몇 개씩 들어있는지 찾고, 가장 많은 글자의 개수 출력
'''

# import sys
# sys.stdin = open('sample_input.txt')

T = int(input())

for tc in range(1, T + 1):
    str1 = list(input())
    str2 = list(input())

    # 1
    # str1의 길이 만큼 빈 리스트 만들기 => str1의 각 요소의 count를 넣는다.
    nums = [0] * len(str1)

    # 2
    # str2의 모든 요소를 for문으로 돌면서, str1에 있다면, 해당 인덱스의 nums에 count
    for i in str2:
        for j in range(len(str1)):
            if i == str1[j]:
                nums[j] += 1
    # 3
    # nums의 max값이 가장 많은 글자의 개수
    print(f'#{tc} {max(nums)}')



