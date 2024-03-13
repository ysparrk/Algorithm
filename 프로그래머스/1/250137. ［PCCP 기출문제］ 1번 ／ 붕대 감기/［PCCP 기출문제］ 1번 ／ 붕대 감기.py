def solution(bandage, health, attacks):

    h_max = health
    sec = 0
    while attacks:
        
        a = attacks.pop(0)
        success = 0
        
        # 현재 시간이 공격 시간보다 작을 때까지
        while sec < a[0]:

            # 연속 성공 확인        
            success += 1
            health += bandage[1]
            
            if success == bandage[0]:
                health += bandage[2]
                success = 0
                
            
            # 최대 체력 확인
            if health > h_max:
                health = h_max
                
            sec += 1
            
        # 공격하기
        health -= a[1]
        sec += 1
    
        if health <= 0:
            return -1
        
    
    return health