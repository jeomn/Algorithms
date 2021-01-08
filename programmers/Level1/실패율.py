#2019 KAKAO BLIND RECRUITMENT
def solution(N, stages):
    rate = []
    challenger = len(stages)

    for i in range(1, N+1):
        fail = stages.count(i) #도전 중
        if challenger == 0: #스테이지에 도달한 유저가 없을 때
            rate.append((i, 0))
        else:
            rate.append((i, fail/challenger))
        challenger -= fail  #전체 도전자 - 도전 중
    
    rate.sort(key = lambda x: x[1], reverse=True)
    answer = [rate[i][0] for i in range(len(rate))]
    
    return answer
