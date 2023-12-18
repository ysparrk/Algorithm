def solution(n, k, cmd):
    # 1. setting
    table = {i: [i-1, i+1] for i in range(n)}  # linked_list
    rlt = ['O' for _ in range(n)]

    table[0] = [None, 1]
    table[n-1] = [n-2, None]

    turn_del = []  # 삭제 리스트

    # 2. result
    for c in cmd:
        # 1) 삭제
        if c == 'C':
            rlt[k] = 'X'
            prev, next = table[k]
            turn_del.append([prev, k, next])

            if next == None:  # 맨아래 -> 위
                k = table[k][0]
            else:
                k = table[k][1]
            
            # 연결리스트 수정
            if prev == None:
                table[next][0] = None
            elif next == None:
                table[prev][1] = None
            else:
                table[prev][1] = next
                table[next][0] = prev

        # 2) 복구
        elif c == 'Z':
            prev, cur, next = turn_del.pop()
            rlt[cur] = 'O'
            # 연결리스트 복구
            if prev == None:
                table[next][0] = cur
            elif next == None:
                table[prev][1] = cur
            else:
                table[next][0] = cur
                table[prev][1] = cur

        # 3) 이동
        else:
            state, d = c.split()
            if state == 'U':
                for _ in range(int(d)):
                    k = table[k][0]

            elif state == 'D':
                for _ in range(int(d)):
                    k = table[k][1]

    return ''.join(rlt)