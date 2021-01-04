def solution(array, commands):
    answer = []
    for n in range(0, len(commands)):
        i = commands[n][0]
        j = commands[n][1]
        k = commands[n][2]
        array_part = sorted(array[(i-1):j])
        answer.append(array_part[k-1])
    return answer
