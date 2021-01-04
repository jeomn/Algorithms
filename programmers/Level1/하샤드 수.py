def solution(x):
    sum_x = sum(int(x) for x in str(x))
    if int(x) % sum_x == 0:
        answer = True
    else:
        answer = False
    return answer
