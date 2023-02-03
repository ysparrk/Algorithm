# N개의 양의 정수에서 가장 큰 수와 가장 작은 수의 차이 출력

# 1
# 테스트 케이스 수 받기
T = int(input())

# 2
for tc in range(1, T+1):
    N = int(input())   # 양수의 개수
    arr = list(map(int, input().split()))   # N개의 양수 리스트로 받기

    # 최대 구하기
    maxV = arr[0]  # arr 첫 요소를 최대로 가정
    for i in range(1, N):   # arr의 모든 요소를 첫번째 원소와 비교
        if maxV < arr[i]:   # 첫번째 요소보다 크다면, 그 값을 첫번째 요소로 변환
            maxV = arr[i]

    # 최소 구하기
    minV = arr[0]
    for i in range(1, N):
        if minV > arr[i]:   # 첫번째 요소보다 작다면, 그 값을 첫번째 요소로 변환
            minV = arr[i]

    print(f'#{tc} {maxV - minV}')