#2020 KAKAO BLIND RECRUITMENT
def solution(s):
    zip_length = []
    answer = 0
    if len(s) == 1:  #입력 문자열 s가 1글자 일때 1 반환
        return 1
    
    #1-문자열을 차례대로 분할(한 글자씩 증가)
    for i in range(1, len(s)-1):
        count = 1
        zip_s = ''
        temp_s = s[:i]
            
        #2-반복되는 문자열 검사
        for j in range(i, len(s), i):
            #temp_s가 반복되면 count++
            if s[j:j+i] == temp_s:
                count += 1
            #반복 안될 때
            else:
                #count == 1(반복X)이면 공백
                if count == 1:
                    count = ""
                #압축 결과 생성
                zip_s += (str(count) + temp_s)
                #반복 횟수 초기화
                count = 1
                #비교할 문자열 갱신
                temp_s = s[j:j+i]
        
        #반복되는 문자열 아예 없을 때
        if count == 1:
            count = ""
        zip_s += (str(count) + temp_s)
        #문자열 검사 후 압축 길이 저장
        zip_length.append(len(zip_s))
            
    answer = min(zip_length)
    return answer
