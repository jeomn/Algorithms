def solution(arr1, arr2):
    answer = []
    
    for arr1_row in arr1:
        row_list = []
        for arr2_col in zip(*arr2):
            mul_list = []
            for a1, a2 in zip(arr1_row, arr2_col):
                mul_list.append(a1*a2)           
            row_list.append(sum(mul_list))
        answer.append(row_list)

    
    return answer
