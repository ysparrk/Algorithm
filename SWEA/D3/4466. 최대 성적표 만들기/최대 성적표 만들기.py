T = int(input())

for tc in range(1, T + 1):

    n, k = map(int, input().split()) # k 과목 선택
    score = list(map(int, input().split()))

    # 내림차순 정렬, k 만큼 slicing
    score.sort(reverse=True)
    score = score[:k]

    print(f'#{tc} {sum(score)}')