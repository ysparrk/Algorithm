# 1. input
str = input()


# 2. backtracking
def solv(part_str, before_idx):
    '''
    1. 입력된 문자열 확인
    2. 문자열 중 가장 빠른 문자 -> rlt에 넣기
    3. rlt 출력
    3. 해당 문자를 기준으로 뒤/앞 슬라이싱 -> 알고리즘 반복
    '''

    # 1) 문자열이 비어 있으면 리턴
    if part_str == '':
        return

    # 2) 다음 문자 찾기
    min_chr = min(part_str)       # 가장 작은 문자
    min_idx = part_str.index(min_chr)  # 가장 작은 문자의 인덱스
    rlt[before_idx + min_idx] = min_chr  # 문자 삽입(떨어진 거리)

    # 3) 출력
    print(*rlt, sep='')

    # 4) 뒤/앞 문자열에 대해 문자 추가
    solv(part_str[min_idx + 1:], before_idx + min_idx + 1) # 뒤
    solv(part_str[:min_idx], before_idx) # 앞


# 3. result
rlt = [''] * len(str)
solv(str, 0)