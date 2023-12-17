def solution(cards1, cards2, goal):
    
    x = cards1.pop(0)
    y = cards2.pop(0)
    for g in goal:
        print(g, x, y)
        if x == g:
            if cards1:
                x = cards1.pop(0)
            else:
                x = ''
            
        elif y == g:
            if cards2:
                y = cards2.pop(0)
            else:
                y = ''
        else:
            return "No"
    
    return "Yes"