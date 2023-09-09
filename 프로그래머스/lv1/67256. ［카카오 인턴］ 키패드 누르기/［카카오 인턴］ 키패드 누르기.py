def solution(numbers, hand):
    answer = ''
    left = [0, 0]
    right = [2, 0]
    
    pleft = ['*', 7, 4, 1]
    pright = ['#', 9, 6, 3]
    pmid = [0, 8, 5, 2]
    
    for n in numbers:
        if n in pleft:
            answer += 'L'
            left = [0, pleft.index(n)] 
            
        elif n in pright:
            answer += 'R'
            right = [2, pright.index(n)]
    
        else:
            ldistance = abs(left[1] - pmid.index(n)) + abs(left[0] - 1)
            rdistance = abs(right[1] - pmid.index(n)) + abs(right[0] - 1)
            
            if ldistance < rdistance:
                answer += 'L'
                left = [1, pmid.index(n)]
                
            elif ldistance > rdistance:
                answer += 'R'
                right = [1, pmid.index(n)]
            
            else:
                if hand == 'left':
                    answer += 'L'
                    left = [1, pmid.index(n)]
                else:
                    answer += 'R'
                    right = [1, pmid.index(n)]
    
    return answer