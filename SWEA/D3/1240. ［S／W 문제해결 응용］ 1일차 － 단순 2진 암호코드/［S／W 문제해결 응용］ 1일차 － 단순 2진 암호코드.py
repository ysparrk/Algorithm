T = int(input())

for tc in range(1, T + 1):

    n, m = map(int, input().split())
    data = [list(input()) for _ in range(n)]
    
    # 1
    # 암호코드인 부분 7자리씩 슬라이싱해서 code에 담기
    code = [0] * 8
    for i in range(n):
        for j in range(m - 1, 0, -1):
            if data[i][j] == '1':
                k = j - 55
                code[0] = data[i][k:k+7]
                code[1] = data[i][k+7:k+14]
                code[2] = data[i][k+14:k + 21]
                code[3] = data[i][k+21:k + 28]
                code[4] = data[i][k+28:k + 35]
                code[5] = data[i][k+35:k + 42]
                code[6] = data[i][k+42:k + 49]
                code[7] = data[i][k+49:k + 56]
                break
    # 2
    # 조건에 맞추어 암호코드 nums에 담기
    nums = []
    for i in code:
        if i == ['0', '0', '0', '1', '1', '0', '1']:
            nums.append(0)
        elif i == ['0', '0', '1', '1', '0', '0', '1']:
            nums.append(1)
        elif i == ['0', '0', '1', '0', '0', '1', '1']:
            nums.append(2)
        elif i == ['0', '1', '1', '1', '1', '0', '1']:
            nums.append(3)
        elif i == ['0', '1', '0', '0', '0', '1', '1']:
            nums.append(4)
        elif i == ['0', '1', '1', '0', '0', '0', '1']:
            nums.append(5)
        elif i == ['0', '1', '0', '1', '1', '1', '1']:
            nums.append(6)
        elif i == ['0', '1', '1', '1', '0', '1', '1']:
            nums.append(7)
        elif i == ['0', '1', '1', '0', '1', '1', '1']:
            nums.append(8)
        elif i == ['0', '0', '0', '1', '0', '1', '1']:
            nums.append(9)
    
    # 3
    # 결과 구하기
    rlt = (nums[0] + nums[2] + nums[4] + nums[6]) * 3 + (nums[1] + nums[3] + nums[5] + nums[7])

    if rlt % 10 == 0:
        print(f'#{tc} {sum(nums)}')
    else:
        print(f'#{tc} 0')