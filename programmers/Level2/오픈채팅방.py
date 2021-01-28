#2019 KAKAO BLIND RECRUITMENT
def solution(record):
    answer = []
    record = [r.split(" ") for r in record]
    nickname = {}
    
    #아이디, 닉네임 매칭 딕셔너리
    for r in record:
        if r[0] in ['Enter', 'Change']:
            nickname[r[1]] = r[2]
    #출력 생성
    for r in record:
        if r[0] == 'Enter':
            answer.append("%s님이 들어왔습니다." % nickname[r[1]])
        elif r[0] == 'Leave':
            answer.append("%s님이 나갔습니다." % nickname[r[1]])
    
    
    return answer
