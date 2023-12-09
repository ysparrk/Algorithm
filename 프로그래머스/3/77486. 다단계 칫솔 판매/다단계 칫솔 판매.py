def solution(enroll, referral, seller, amount):
    p_num = len(enroll)
    profit = [0] * (p_num)  # 이익 집계

    # 1. enroll 딕셔너리 만들기
    enroll_dict = {name: i for i, name in enumerate(enroll)}


    # 2. 탐색
    for j in range(len(seller)):
        sell_idx = enroll_dict[seller[j]]  # 파는 사람
        sell_profit = amount[j] * 100 - amount[j] * 100 // 10
        profit[sell_idx] += sell_profit  # 내 가격

        # 부모 차례대로 더해주기
        temp = amount[j] * 100 - sell_profit # 처음 시작하는 가격
        while True:
            parent_name = referral[sell_idx]
            if parent_name == '-':
                break

            else:
                parent_idx = enroll_dict[parent_name]
                temp_to = temp // 10  # 줄거
                if temp_to >= 1:
                    profit[parent_idx] += (temp - temp_to)
                else:
                    profit[parent_idx] += temp
                    break
                sell_idx = parent_idx
                temp = temp_to

    return profit