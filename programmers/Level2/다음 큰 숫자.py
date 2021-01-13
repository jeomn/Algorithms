from collections import Counter
def solution(n):
    answer = 0
    cn = Counter(bin(n))
    
    while True:
        n +=1
        cbn = Counter(bin(n))
        if cn['1'] == cbn['1']:
            answer = n
            break

    return answer
