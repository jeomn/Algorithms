def solution(x):
    sum_x = sum(int(x) for x in str(x))
    if int(x) % sum_x == 0:
        answer = True
    else:
        answer = False
    return answer


#20210105_review
"""
def solution(x):
    x_list = []
    cx = x
    for i in range(x):
        if x >= 10:
            x_list.append(x%10)
            x //= 10
        else:
            x_list.append(x%10)
            break
    print(x_list)
    sum_x = sum(x_list)
    print(sum_x)
    if cx%sum_x == 0:
        answer = True
    else:
        answer = False
    return answer
"""
