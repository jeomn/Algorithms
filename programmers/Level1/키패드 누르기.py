#2020 카카오 인턴십
def solution(numbers, hand):
    answer = ''
    left, right = 10, 12
    
    for i in range(len(numbers)):
        input_key = numbers[i]
        if input_key == 0:
            input_key = 11
            
        if input_key in (1, 4, 7):
            answer += 'L'
            left = input_key
        elif input_key in (3, 6, 9):
            answer += 'R'
            right = input_key
        else:
            key = (input_key%3) + (input_key//3)
            lx, ly = divmod(abs(input_key-left), 3)
            rx, ry = divmod(abs(input_key-right), 3)
            ld = lx+ly
            rd = rx+ry
            
            if ld > rd:
                answer += 'R'
                right = input_key
            elif ld < rd:
                answer += 'L'
                left = input_key
            elif ld == rd:
                if hand == 'right':
                    answer += 'R'
                    right = input_key
                else:
                    answer += 'L'
                    left = input_key
            
    return answer
