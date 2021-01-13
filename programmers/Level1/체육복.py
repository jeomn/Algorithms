#탐욕법

def solution(n, lost, reserve):
    set_lost = set(lost) - set(reserve)
    set_reserve = set(reserve) - set(lost)
    
    for l in set_reserve:
        if l-1 in set_lost:
            set_lost.remove(l-1)
        elif l+1 in set_lost:
            set_lost.remove(l+1)
    
    return n - len(set_lost)


#20210107_review
def solution(n, lost, reserve):
    set_lost = set(lost) - set(reserve)
    set_reserve = set(reserve) - set(lost)
    
    for i in set_reserve:
        if i-1 in set_lost:
            set_lost.remove(i-1)
        elif i+1 in set_lost:
            set_lost.remove(i+1)
    
    answer = n - len(set_lost)
    return answer

