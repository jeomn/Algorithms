def solution(n):
    answer = ''
    for i in range(n):
        print(n)
        if (n/3)%1 == 0: #3번째
            answer += "4"  
        else:
            answer += str(n%3)
        
        if n <= 3:
            break
        else:
            if (n/3)%1 == 0:
                n = n//3 - 1
            else:
                n //= 3
       
    return answer[::-1]
