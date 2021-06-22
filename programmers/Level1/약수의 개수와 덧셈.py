#20210622
#월간 코드 챌린지 시즌2


def solution(left, right):
    answer = 0
    
    for num in range(left, right+1):
        count = 0
        for n in range(1, num+1):
            if num%n == 0:
                count += 1
        
        if count % 2 == 0:
            answer += num
        else:
            answer -= num
    
    
    return answer
