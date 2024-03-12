def solution(sequence):
    N = len(sequence)
    dp1 = [0] * N
    dp2 = [0] * N
    
    dp1[0] = sequence[0] * -1      # 0, 2, 4...  -1 곱하기
    dp2[0] = sequence[0]           # 1 3 5 ... -1 곱하기
    
    
    for i in range(1, N):
        # i를 끝으로 하는 부분수열의 합의 최댓값
        if i % 2 == 0:
            dp1[i] = max(sequence[i] * -1, dp1[i - 1] + sequence[i] * -1)
            dp2[i] = max(sequence[i], dp2[i - 1] + sequence[i])
        else:
            dp1[i] = max(sequence[i], dp1[i - 1] + sequence[i])
            dp2[i] = max(sequence[i] * -1, dp2[i - 1] + sequence[i] * -1)
            
    
    return max(max(dp1), max(dp2))