#완전탐색
def solution(brown, yellow):
    answer = []
    total = brown + yellow
    
    for i in range(2, total-2):
        if total % i == 0:
            for j in range(1, i+1):
                cx = (2*i)+(2*(j-2))
                cy = (i-2)*(j-2)
                if brown == cx and yellow == cy:
                    answer.append(i)
                    answer.append(j)
                    break
    
    return answer
