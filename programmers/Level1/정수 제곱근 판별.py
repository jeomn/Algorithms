def solution(n):
    x = n**(1/2)
    if x%1 == 0:
        answer = int((x+1)**2)
    else:
        answer = -1
    
    return answer
