from collections import defaultdict
from itertools import product
from bisect import bisect_left

def solution(info, query):
    info = [tuple(e.split(" ")) for e in info]
    queries = [tuple(e for e in q.split(" ") if e != 'and') for q in query]
    scores = defaultdict(list)

    for entry in info:
        for record in product(*tuple(('-', e) for e in entry[:-1])):
            scores[record].append(int(entry[-1]))
    for record in scores:
        scores[record].sort()

    output = []
    for query in queries:
        record, score = query[:-1], int(query[-1])
        output.append(len(scores[record]) - bisect_left(scores[record], score))
    return output
