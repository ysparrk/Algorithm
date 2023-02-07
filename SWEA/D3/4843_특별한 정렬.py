'''

N개의 정수가 주어지면, 가장 큰 수, 가장 작은 수, 2번째 큰 수, 2번째 작은 수


'''

import sys
sys.stdin = open('sample_input.txt')

T = int(input())

for tc in range(1, T + 1):
    n = int(input())
    nums = list(map(int, input().split()))

    # 1
    # 선택정렬 사용한다.
    # i가 홀수일때는 최소, 짝수일때는 최대를 구하게 된다.
    for i in range(n - 1):
        if i % 2:  # i값이 홀수라면
            idx = i
            for j in range(i + 1, n):
                if nums[idx] > nums[j]:  # 주어진 범위에서 최솟값
                    idx = j
            nums[i], nums[idx] = nums[idx], nums[i]  # 최솟값을 찾아서 i값과 자리변환

        else:    # i값이 짝수라면
            idx = i
            for j in range(i + 1, n):
                if nums[idx] < nums[j]:  # 주어진 범위에서 최댓값
                    idx = j
            nums[i], nums[idx] = nums[idx], nums[i]
    # 3
    # 정렬한 것 10개 슬라이싱
    result = nums[:10]
    print(f'#{tc}', *result, sep=' ')
