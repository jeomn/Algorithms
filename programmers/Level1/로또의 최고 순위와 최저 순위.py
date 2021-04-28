#20210428
#2021 Dev-Matching: 웹 백엔드 개발자(상반기)

def solution(lottos, win_nums):
    answer = []
    
    win_dict = {6: 1, 5: 2, 4: 3, 3: 4, 2: 5, 1: 6, 0: 6}
    
    matching_num, zero_num = 0, 0
    for lotto_num in lottos:
        if lotto_num == 0:
            zero_num += 1
            continue

        if lotto_num in win_nums:
            matching_num += 1
    
    answer.append(win_dict[zero_num+matching_num])
    answer.append(win_dict[matching_num])
    
    
    return answer
