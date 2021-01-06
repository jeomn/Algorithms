def solution(n):
    answer = ""
    for i in range(1, n+1):
        if i%2 == 1:
            answer += "수"
        if i%2 == 0:
            answer +="박"
    return answer


#20210106_review
def solution(n):
    answer = "수박" * n
    return answer[:n]
