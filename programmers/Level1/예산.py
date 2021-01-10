#Summer/Winder Coding(~2018)
def solution(d, budget):
    answer = 0
    d.sort()
    
    for i in range(len(d)):
        sum = d[i]
        if sum > budget:
            count = 0
        else:
            count = 1
        for j in range(i+1, len(d)-i):
            if sum + d[j] <= budget:
                sum += d[j]
                count += 1
        if answer < count:
            answer = count
        if count == len(d):
            break
    return answer
