#해시
def solution(clothes):
    clothes_table = {}
    count = 1
    
    for i in clothes:
        #입은 의상에 같은 종류가 있으면
        if i[1] in clothes_table.keys():
            clothes_table[str(i[1])] += 1
        else:
            clothes_table[str(i[1])] = 1

    for i in clothes_table.values():
        count *= (i+1)
    
    answer = count - 1
    return answer
