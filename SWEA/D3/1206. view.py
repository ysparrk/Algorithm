'''
조망권
왼쪽과 오른쪽으로 창문을 열었을 때, 양쪽 모두 거리 2 이상의 공간이 확보 => 조망권 확보
조망권이 확보된 세대의 수 반환

N = 건물의 개수 4 ~ 1000
N개의 건물의 높이 0~255
기준 되는 것 말고, 양 옆으로 가장 높은 값을 구해서 뺐을때, 0보다 커야 한다.
'''

# input
T = 10
for tc in range(1, T + 1):  # 테스트 케이스 10개
    N = int(input())  # 건물의 개수
    build = list(map(int, input().split()))  # N개의 건물의 높이
    sum = 0  # 조망권 확보 세대 더할 곳

    # 1
    # 2~N-3 까지 범위.
    for i in range(2, N-2):

        top = []   # i의 양옆 두개씩의 건물의 높이를 담을 리스트.
        for b in range(1, 3):
            right = build[i + b]
            left = build[i - b]

            top.append(right)
            top.append(left)

        # 2
        # top의 최댓값을 구한다.
        maxV = top[0]
        for n in range(4):
            if maxV < top[n]:
                maxV = top[n]

        # 3
        # top의 최댓값이 맨 처음 기준 i값 보다 작다면 => 조망권 확보!
        # 그 차이를 sum에 더해준다.
        if build[i] > maxV:
            sum += build[i] - maxV

    print(f'#{tc} {sum}')

