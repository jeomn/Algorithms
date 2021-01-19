#2020 KAKAO BLIND RECRUITMENT
#균형잡힌 문자열 반환
def balanced_string(string):
    u, v = [], []
    for i in range(1, len(string)+1):
        sample = string[:i]
        if sample.count("(") == sample.count(")"):
            u = sample
            v = string[i:]
            return u, v
    return u, v

#올바른지 검사
def check_string(string):
    check = 0
    for i in string:
        if i == "(":
            check += 1
        else:
            check -= 1
        if check < 0:
            return False

    return True
    

def solution(p):
    u = []
    v = []

    if check_string(p):
        return p    
    u, v = balanced_string(p)
    
    if check_string(u):
        answer = u + solution(v)
    else:
        answer = "(" + solution(v) + ")" + u[1:-1].replace("(", "0").replace(")", "(").replace("0", ")")
    
    return answer
