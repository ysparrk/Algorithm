switch = int(input())  # 스위치 개수
state = list(map(int, input().split())) # 스위치 상태
st_num = int(input()) # 학생 수

for _ in range(st_num):

    gen, num = map(int, input().split())
    # 1
    # 남자
    if gen == 1:
        i = num - 1  # 인덱스
        while True:
            if i < switch and state[i] == 0:  # i가 switch보다 작아야 한다.
                state[i] = 1                  # 스위치의 상태에 따라 끄고, 키기
                i += num
            elif i < switch and state[i] == 1:
                state[i] = 0
                i += num
            else:           # i(인덱스)가 switch 보다 같거나 그게 되면 range 벗어남으로 break
                break
    # 2
    # 여자
    # num의 인덱스를 기준으로 양 옆이 같은지 확인.
    # 같으면 cnt+1을 해서 나중에 구한 cnt값으로 상태를 바꿀 스위치 range 설정
    else:
        # 2-1
        i = num - 1
        cnt = 1
        while True:
            if i - cnt >= 0 and i + cnt < switch and state[i - cnt] == state[i + cnt]:
                cnt += 1

            else:
                break
        # 2-2
        r = cnt - 1
        for j in range(i - r, i + r + 1):
            if state[j] == 0:
                state[j] = 1
            else:
                state[j] = 0

# 3
# 한 줄에 20개씩 출력한다.
# 20씩 슬라이싱 + i의 값은 + 20
for i in range(0, len(state), 20):
    print(*state[i : i + 20])