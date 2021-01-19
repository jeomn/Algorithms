def solution(s):
    check = 0
    s_list = []    

    for i in range(len(s)):
        #공백문자면 추가
        if s[i] == ' ':
            s_list.append(s[i])
            check = 0
        #공백문자가 아니고, check가 0이면(' '이 아니었으면)
        elif s[i] != ' ' and check == 0:
            check += 1
            s_list.append(s[i][0].upper())
        elif s[i] != ' ' and check != 0:
            s_list.append(s[i][0].lower())


    answer = ''.join(s_list)
    return answer
