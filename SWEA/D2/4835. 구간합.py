'''
N개의 정수가 들어있는 배열, 이웃한 M개의 합 계산
M개의 합 max case, min case의 차이 출력

합을 다 출력..?


'''
# input
T = int(input())
for tc in range(1, T+1):
    n, m = map(int, input().split())

    num_list = list(map(int, input().split()))

    # 최대 구하기
    maxV = sum(num_list[0:m])  # 가장 처음부터 m개의 합을 maxV로 선언
    for i in range(1, n-m+1):  # for문이 1부터 n-m까지 돌 수 있도록 범위 선정
        if maxV < sum(num_list[i:i+m]):   # i = 1일때부터 인덱스+m만큼의 합과 maxV를 비교
            maxV = sum(num_list[i:i+m])   # 더 크다면 대체

    # 최소 구하기
    minV = sum(num_list[0:m])
    for i in range(1, n-m+1):
        if minV > sum(num_list[i:i + m]):
            minV = sum(num_list[i:i + m])

    print(f'#{tc} {maxV - minV}')



