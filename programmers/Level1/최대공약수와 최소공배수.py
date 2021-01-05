def solution(n, m):
    min, Max = 1, 0
    for i in range(2, n+1):
        if n%i == 0 and m%i == 0:
            min = i
    Max = (n//min)*(m//min)*min
            
    answer = [min, Max]
    return answer
