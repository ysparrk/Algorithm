from heapq import heappush, heappop

def solution(n, k, enemy):
    rlt, tmp_sum = 0, 0
    
    heap = []
    
    for e in enemy:
        heappush(heap, -e)
        tmp_sum += e
        
        if tmp_sum > n:
            # 종료 조건
            if k == 0:
                break
            else:
                tmp_sum += heappop(heap)  # sum에서 최댓값 제거
                k -= 1

        rlt += 1
    
    return rlt