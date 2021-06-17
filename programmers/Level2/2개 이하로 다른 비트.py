#월간 코드 챌린지 시즌2
#20210618
def solution(numbers):
    answer = []
    
    for number in numbers:
        if number%2 == 0:
            answer.append(number+1)
        else:
            bin_number = bin(number)
            bin_number = '0b'+'0'+bin_number[2:]
            change_idx = bin_number.rfind('01')
            bin_number = list(bin_number)
            bin_number[change_idx:change_idx+2] = '10'
            answer.append(int(''.join(bin_number), 2))
            
    return answer
