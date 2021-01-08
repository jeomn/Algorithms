#월간 코드 챌린지 시즌1
def solution(numbers):
    cal_nums = [numbers[i]+numbers[j] for i in range(0, len(numbers)-1) for j in range(i+1, len(numbers))]
    answer = sorted(list(set(cal_nums)))
    return answer
