#20210428
#월간 코드 챌린지 시즌2

def solution(absolutes, signs):
    
    answer = 0    
    for idx in range(len(absolutes)):
        if signs[idx] == True:
            answer += absolutes[idx]
        else:
            answer -= absolutes[idx]
    
    return answer
