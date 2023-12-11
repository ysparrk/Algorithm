# 0. import
import heapq


def solution(n, works):
    if sum(works) <= n:
        return 0

    # 1. 우선순위 큐
    works = [-x for x in works]
    heapq.heapify(works)

    while n > 0:
        temp = heapq.heappop(works)
        temp += 1
        heapq.heappush(works, temp)
        n -= 1

    rlt = [x ** 2 for x in works]

    return sum(rlt)