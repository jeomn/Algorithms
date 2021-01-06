def solution(s):
    if s.isdigit() == True and len(s) == 4 or len(s) == 6:
        answer = True
    else:
        answer = False
    
    return answer


#20210106_review
def solution(s):
    if len(s) == 4 or len(s) == 6:
        if s.isdigit() == True:
            return True
        else: return False
    else: return False
