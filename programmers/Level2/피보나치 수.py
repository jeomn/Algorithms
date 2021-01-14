def solution(n):
    answer = 0
    n0 = 0
    n1 = 1
    
    for i in range(n):
        n0, n1 = n1, n0+n1
    
    answer = n0%1234567
    return answer
