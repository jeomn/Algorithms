#정렬
def solution(array, commands):
    answer = []
    for n in range(0, len(commands)):
        i = commands[n][0]
        j = commands[n][1]
        k = commands[n][2]
        array_part = sorted(array[(i-1):j])
        answer.append(array_part[k-1])
    return answer


#20210107_review
def solution(array, commands):
    answer, _array = [], []
    for i in range(0, len(commands)):
        f = commands[i][0]-1
        l = commands[i][1]
        n = commands[i][2]-1
        _array = array[f:l]
        _array.sort()
        answer.append(_array[n])
    
    return answer

