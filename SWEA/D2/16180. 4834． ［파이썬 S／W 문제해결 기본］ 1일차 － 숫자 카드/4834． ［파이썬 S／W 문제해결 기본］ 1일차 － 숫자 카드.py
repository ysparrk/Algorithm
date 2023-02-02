'''
0~9 숫자가 적힌 N장의 카드.
가장 많은 카드에 적힌 숫자, 카드가 몇장인지 출력
카드 장수가 같을 때는 숫자가 큰 쪽 선택
'''
# input
T = int(input())

# 1
for tc in range(1, T + 1):
    N = int(input())
    card = list(map(int, str(input())))  #숫자를 받아서 하나씩 리스트에 넣는다.

    # 2
    # 0~9 숫자가 각각 몇개씩 있는지 lcount에 넣기
    lcount = [0] * (10)
    for i in range(0, len(card)):
        lcount[card[i]] += 1

    # 3
    # lcount에서 최댓값 찾기
    maxN = lcount[0]
    maxCh = []         # maxN이 바뀔때 그 i 값을 모으는 리스트 선언
    for i in range(0, 10):
        if maxN <= lcount[i]:
            maxN = lcount[i]
            maxCh.append(i)

    # 4
    # 출력할때, maxCh의 가장 마지막 값이 가장 많은 카드의 숫자이다.
    print(f'#{tc} {maxCh[-1]} {maxN}')