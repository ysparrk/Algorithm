'''
cache hit : 이미 들어 있음
cache miss : cahce에 들어있지 않음
'''
def solution(cacheSize, cities):
    cache = []
    ans = 0
    for city in cities:
        city = city.lower()
        if cacheSize:
            if not city in cache:
                if len(cache) == cacheSize:
                    cache.pop(0)
                cache.append(city)
                ans += 5
            else:
                cache.pop(cache.index(city))
                cache.append(city)
                ans += 1
        
        else:
            ans += 5
    
    return ans