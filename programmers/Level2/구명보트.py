#탐욕법(Greedy)
def solution(people, limit):
    people.sort()
    i = 0
    j = len(people)-1
    count = 0
    
    while i<=j:
        #일단 보트 한 대
        count += 1
        #두 사람의 몸무게 합을 비교, limit보다 작거나 같으면 둘 다 태우고
        #limit보다 크면 한 사람만 태우고
        #둘 다 태운다 == 한 사람 차례를 넘긴다
        if people[i] + people[j] <= limit:
            i += 1
        #어쨌든 한 사람 태웠다
        j-=1    
        
    answer = count
    return answer
