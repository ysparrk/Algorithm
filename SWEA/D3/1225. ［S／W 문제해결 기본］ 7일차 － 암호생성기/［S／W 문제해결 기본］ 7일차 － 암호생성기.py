T = 10
for _ in range(1, T + 1):
    # 1 초기설정
    tc = int(input())
    nums = list(map(int, input().split()))
    idx = 0
    minus = [1, 2, 3, 4, 5]

    # 2
    # 1) 1 ~ 5씩 하나씩 계속 빼준다.
    # 2) 계속 빼다가 뺀 값이 0이하의 수가 될 때 while문 종료.
    # 3) 0이된 idx값을 추출해서 슬라이싱(교환)
    j = 0
    while True:
        for i in range(8):
            # 2-1. nums - minus의 값이 0이하인 경우, nums[i] = 0으로 만들고 break
            if nums[i] - minus[j] <= 0:
                nums[i] = 0
                break
            else:
                nums[i] -= minus[j]  # 아닌 경우 minus
                idx += 1
                if idx == 8:  # idx는 7까지 있다. 8이되면 0으로 갱신
                    idx = 0

            # 2-2. j는 minus의 인덱스. 4가 될 경우 0으로 다시 갱신
            if j == 4:
                j = 0
            else:
                j += 1
        else:
            continue
        break

    # 3
    # idx를 기준으로 idx 뒤의 값들이 앞으로 오고, 그 앞의 값들은 뒤로 간다
    rlt = nums[idx+1:] + nums[:idx + 1]
    print(f'#{tc}', *rlt)