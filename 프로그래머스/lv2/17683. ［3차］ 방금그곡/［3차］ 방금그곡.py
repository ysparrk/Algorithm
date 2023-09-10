# 0. import
from datetime import datetime
import time

# 1. change method
def code_to_small(info): 
    info = info.replace('C#', 'c')
    info = info.replace('D#', 'd')
    info = info.replace('F#', 'f')
    info = info.replace('G#', 'g')
    info = info.replace('A#', 'a')    
    return info

# 2. solution method
def solution(m, musicinfos):
    ans = ''
    ans_minute = 0
    m = code_to_small(m)

    for i in musicinfos:
        info = i.split(',')
        info[3] = code_to_small(info[3])
        
        # 1) playTime
        time1 = datetime.strptime(info[1], '%H:%M')
        time2 = datetime.strptime(info[0], '%H:%M')
        minute = (time1 - time2).total_seconds() / 60
        minute_div = divmod(int(minute), len(info[3]))
        
        # 2) playedMelody
        melody = info[3] * minute_div[0] + info[3][:minute_div[1]]               
        
        # 3) find m
        for j in range(len(melody)-len(m)+1):
            if melody[j] == m[0]:
                for k in range(1, len(m)):            
                    if melody[j+k] != m[k]:
                        break          
                else:
                    if ans_minute < minute:
                        ans_minute = minute
                        ans = info[2]
                    break
                    

    # 2. answer
    if ans == '':
        return '(None)'
    else:
        return ans