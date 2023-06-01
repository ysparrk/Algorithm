'''
누적된 값이 최소가 되도록
-> 최대 * 최소 곱하기
'''

def solution(A,B):
    answer = 0
    A.sort(reverse=True)
    B.sort(reverse=False)

    for i in range(len(A)):
        answer += (A[i] * B[i])
            
    
    return answer