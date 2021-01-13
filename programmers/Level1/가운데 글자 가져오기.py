def solution(s):
    answer = ''
    if len(s)%2 == 0:
        answer = s[(len(s)//2)-1 : (len(s)//2)+1]
    else:
        answer = s[(len(s)//2)]
    return answer


#20210107_review
def solution(s):
    num_s = len(s)
    if num_s%2 == 0:
        return s[(num_s//2)-1 : (num_s//2)+1]
    elif num_s%2 ==1:
        return s[num_s//2]

    
