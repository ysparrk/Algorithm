# 0. import
import heapq
import sys
input = sys.stdin.readline

# 1. input
T = int(input())

for _ in range(T):
    k = int(input())

    # 2. heap
    min_heap =[]
    max_heap= []
    is_deleted = [0] * k
    for i in range(k):
        state, n = input().split()
        num = int(n)

        if state == 'I':
            heapq.heappush(min_heap, (num, i))
            heapq.heappush(max_heap, (-num, i))  # 최대 힙

        else:
            # 1) max 삭제
            if num == 1:
                # is_deleted가 0인게 나올때까지 삭제
                while max_heap and is_deleted[max_heap[0][1]]:
                    heapq.heappop(max_heap)
                if max_heap:
                    is_deleted[max_heap[0][1]] = 1
                    d = heapq.heappop(max_heap)

            # 2) min 삭제
            else:
                while min_heap and is_deleted[min_heap[0][1]]:
                    heapq.heappop(min_heap)

                if min_heap:
                    is_deleted[min_heap[0][1]] = 1
                    heapq.heappop(min_heap)


    # 3. result
    # 1) is_deleted true 정리
    while max_heap and is_deleted[max_heap[0][1]]:
        heapq.heappop(max_heap)

    while min_heap and is_deleted[min_heap[0][1]]:
        heapq.heappop(min_heap)

    # 2) 비어있지 않으면 출력
    if min_heap and max_heap:
        max_rlt = heapq.heappop(max_heap)[0] * -1
        min_rlt = heapq.heappop(min_heap)[0]

        print(max_rlt, min_rlt)
    else:
        print("EMPTY")