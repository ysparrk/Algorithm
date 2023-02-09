T = int(input())
for tc in range(1, T + 1):
    # 1
    # 초기 설정
    strT = list(input().split())  # 공백 제거하고 받기 -> 글자 하나씩 리스트에 담기
    strA = list(strT[0])
    strB = list(strT[1])
    n = len(strA)
    m = len(strB)

    # 2
    # strB의 길이 만큼 슬라이싱해서 비교 후,
    # strB와 같다면 cnt+1 and 인덱스에 +m해서 건너뛰고 다음 인덱스 비교
    # 같지 않다면 인덱스에 +1해서 다음 인덱스 비교
    i = 0
    cnt = 0  # strB가 눌리는 횟수
    while i <= n - m:
        if i <= n - m and strA[i : i + m] == strB:
            cnt += 1
            i += m
        else:
            i += 1
    # 3
    # B가 아닌 strA 개수 + cnt
    rest = n - (cnt * m)
    print(f'#{tc} {cnt + rest}')