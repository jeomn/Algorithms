#2018 KAKAO BLIND RECRUITMENT
def solution(cacheSize, cities):
    answer = 0
    cache = []
    cities = [city.lower() for city in cities]    
    
    if cacheSize == 0:
        return 5*len(cities)
    
    for city in cities:
        #cache hit!
        if city in cache:
            answer += 1
            idx = cache.index(city)
            del cache[idx]
            cache.append(city)
        #cache miss!
        else:
            answer += 5
            if len(cache) < cacheSize:
                cache.append(city)
            else:
                del cache[0]
                cache.append(city)

    return answer
