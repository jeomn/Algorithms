def solution(A,B):
    answer = 0
    sortA = sorted(A)
    sortB = sorted(B, reverse=True)
    mul = 1
    
    for i in range(len(A)):
        mul = sortA[i] * sortB[i]        
        answer += mul
    
    return answer
