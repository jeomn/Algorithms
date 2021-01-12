#2018 KAKAO BLIND RECRUITMENT
def solution(dartResult):
    num, dart_time = 0, 0
    dartScore = []
    
    for i in range(len(dartResult)):
        #숫자 판별
        if dartResult[i].isdigit():
            #10은 두자리니까 10일 때
            if num == 1 and dartResult[i] == '0':
                num = 10
            #10이 아닌 숫자
            else:
                num = int(dartResult[i])
                #몇번째 기회의 점수 측정인지
                dart_time += 1
            continue
        
        #보너스 점수 표현
        if dartResult[i] == 'S':
            dartScore.append(num)
        elif dartResult[i] == 'D':
            num = num**2
            dartScore.append(num)
        elif dartResult[i] == 'T':
            num = num **3
            dartScore.append(num)
        

        #옵션 표현
        if dartResult[i] == '*':
            #첫번째 기회에서의 스타상
            if dart_time == 1:
                dartScore[dart_time-1] *= 2
            else:
                dartScore[dart_time-1] *= 2
                dartScore[dart_time-2] *= 2
        elif dartResult[i] == '#':
            dartScore[dart_time-1] *= (-1)

        
    answer = sum(dartScore)
    return answer
