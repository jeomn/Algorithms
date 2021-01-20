#2017 팁스타운
def solution(s):
    compare_list = []

    for string in s:
        if len(compare_list) == 0:
            compare_list.append(string)
        elif string == compare_list[-1]:
            del compare_list[-1]
        else:
            compare_list.append(string)

    if len(compare_list) == 0:
        answer = 1
    else:
        answer = 0
     
    return answer
