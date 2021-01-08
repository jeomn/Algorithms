#월간 코드 챌린지 시즌1
def solution(n):
    answer = 0
    nbase3 = ''
    
    #거꾸로 3진법
    while n > 0:      
        nbase3 += str(n % 3)
        n //= 3
    #10진법으로
    for i in range(len(nbase3)):
        answer += int(nbase3[-(i+1)])*(3**i)
    
    return answer
