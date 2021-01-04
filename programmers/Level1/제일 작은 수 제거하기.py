def solution(arr):
    answer = []
    arr.remove(min(arr))
    if len(arr) == 0:
        answer = [-1]
    else:
        answer = arr
    
    return answer

#가장 작은 수가 여러 개일 경우 하나만 제거됨(ex. [4, 3, 2, 1, 1, 1] > [4, 3, 2, 1, 1])
