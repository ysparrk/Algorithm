def solution(name, yearning, photo):    
    rlt = []
    people = dict(zip(name, yearning))
    
    for p in photo:
        score = 0
        for person in p:
            score += people.get(person, 0)

        rlt.append(score)
    
    return rlt