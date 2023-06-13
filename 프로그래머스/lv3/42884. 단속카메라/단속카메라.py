'''
고속도로를 이용하면서 단속용 카메라를 한 번은 만나도록 설치
최소 몇 대의 카메라를 설치해야 하는지 return
'''

def solution(routes):
    # 1. 진입지점으로 정렬
    routes.sort(key=lambda x: x[1])

    # 2. 진입시점에 카메라가 없으면 카메라 설치
    answer = 0
    camera = -30001 # 카메라 초기 위치
    
    for route in routes:
        if camera < route[0]: 
            answer += 1
            camera = route[1]  # 나간 지점에 카메라 설치
    return answer
    
