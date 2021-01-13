def solution(a, b):
    answer = 0
    if a > b:
        a, b = b, a
    for i in range(a, b+1):
        answer += i
    return answer


#20210107_review
def solution(a, b):
    answer = 0
    n = abs(a-b)
    m = min(a, b)
    for i in range(m, m+n+1):
        answer += i
    return answer

