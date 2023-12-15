# 1. dp
def solution(play_time, adv_time, logs):
    # 1) 초단위 저장
    play_time = time_to_second(play_time)
    adv_time = time_to_second(adv_time)
    dp = [0 for _ in range(play_time + 1)]  #

    # 2) 시청자 수(시작, 끝)
    for l in logs:
        start, end = l.split('-')  # 나누기
        start, end = time_to_second(start), time_to_second(end)  # 바꾸기
        dp[start] += 1  # 시작점 더하기
        dp[end] -= 1 # 종료 빼기

    # 3) 구간별 시청자수 기록
    for i in range(1, len(dp)):
        dp[i] = dp[i] + dp[i - 1]

    # 4) 모든 구간 시청자 누적 기록
    for i in range(1, len(dp)):
        dp[i] = dp[i] + dp[i - 1]

    # 5) 가장 시청자 수가 많은 구간 탐색
    most_view = 0
    max_time = 0
    for i in range(adv_time - 1, play_time):
        if i >= adv_time:
            if most_view < dp[i] - dp[i - adv_time]:
                most_view = dp[i] - dp[i - adv_time]
                max_time = i - adv_time + 1
        else:
            if most_view < dp[i]:
                most_view = dp[i]
                max_time = i - adv_time + 1

    return second_to_time(max_time)


# 2. 시간 -> 초
def time_to_second(time):
    h, m, s = time.split(':')
    return int(h) * 3600 + int(m) * 60 + int(s)


# 3. 초 -> 시간
def second_to_time(time):
    h = time // 3600
    h = '0' + str(h) if h < 10 else str(h)
    time = time % 3600
    m = time // 60
    m = '0' + str(m) if m < 10 else str(m)
    time = time % 60
    s = '0' + str(time) if time < 10 else str(time)
    return h + ':' + m + ':' + s