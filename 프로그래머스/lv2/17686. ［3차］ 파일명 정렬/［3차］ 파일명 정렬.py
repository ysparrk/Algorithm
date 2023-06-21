def solution(files):
    temp = []
    
    # 1. list up
    for file in range(len(files)):
        head, number = '', ''
        
        num = False
        for f in files[file]:
            if f.isdigit():  # head
                number += f
                num = True
            elif not num:   # number
                head += f.lower()
            else:    
                break 
        temp.append([head, int(number), file])
    
    # 2. sort
    temp.sort(key=lambda x: [x[0], x[1], x[2]])
    
    # 3. result
    result = [files[x[-1]] for x in temp]
    return result