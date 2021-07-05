import sys
from collections import deque


input_func = sys.stdin.readline
if __name__ == '__main__':
    T = int(*map(int, input_func().split()))

    roman_to_arabic_dict = {'I': 1, 'II': 2, 'III': 3, 'IV': 4, 'V': 5, 'VI': 6, 'VII': 7, 'VIII': 8, 'IX': 9,
                   'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    arabic_to_roman_dict = {1: 'I', 2: 'II', 3: 'III', 5: 'V', 6: 'VI', 7: 'VII', 8: 'VIII',
                   10: 'X', 50: 'L', 100: 'C', 500: 'D', 1000: 'M'}

    for _ in range(T):
        number = str(*map(str, input_func().split()))

        roman, arabic = deque(), deque()
        if number.isdigit():
            arabic = list(reversed(number))
            for idx in range(len(arabic)):
                num = int(arabic[idx])
                num_digit = pow(10, idx)
                if num == 4:
                    change_num = arabic_to_roman_dict[num_digit] + arabic_to_roman_dict[5*num_digit]
                elif num == 9:
                    change_num = arabic_to_roman_dict[num_digit] + arabic_to_roman_dict[10*num_digit]
                else:
                    if idx == 0 and num != 0:
                        change_num = arabic_to_roman_dict[num]
                    elif num >= 5:
                        change_num = arabic_to_roman_dict[5*num_digit]+arabic_to_roman_dict[num_digit]*(num-5)
                    else:
                        change_num = arabic_to_roman_dict[num_digit]*num

                roman.appendleft(change_num)

            print(''.join(roman))

        else:
            arabic_number = 0
            for idx in range(len(number)):
                arabic.append(roman_to_arabic_dict[number[idx]])

            pass_flag = False
            for idx in range(len(arabic)-1):
                if pass_flag:
                    pass_flag = False
                    continue

                if arabic[idx] < arabic[idx+1]:
                    arabic_number += int(str(arabic[idx+1]-1)[0])*arabic[idx]
                    pass_flag = True
                else:
                    arabic_number += arabic[idx]

            if not pass_flag:
                arabic_number += arabic[-1]

            print(arabic_number)
