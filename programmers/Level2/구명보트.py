"""
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
"""



#210201 리뷰
#탐욕법(Greedy)
def solution(people, limit):
    answer = 0
    people.sort()
    #사람 수
    i = 0               #건넌 사람
    j = len(people)-1   #섬 사람(index)

    while i<=j:
        #구명보트 갯수
        answer += 1

        #구명보트에 탈 사람(제일 가벼운 사람), 제일 무거운 사람 비교
        if people[i] + people[j] <= limit:
            #보트에 태우고, 다음 사람으로
            i += 1
        
        #맨 뒷 사람
        j-=1
    
    return answer

