def solution(num):
    answer = -1
    for i in range(1, 501):
        if num%2 == 0:
            num /= 2
        elif num%2 != 0 and num != 1:
            num = (num*3)+1
        elif num == 1:
            answer = i-1
            break
    
    return answer
