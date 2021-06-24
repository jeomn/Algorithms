import sys


def make_palindrome(num):
    string_num = str(num)
    str_temp = string_num[:-1][::-1]
    rev = string_num[::-1]
    if len(string_num) == 1:
        palindrome_list.append(num)
        palindrome_list.append(int(string_num+string_num))
    else:
        palindrome_list.append(int(string_num+rev))
        palindrome_list.append(int(string_num+str_temp))


def is_prime_number(num):
    m = int(num**0.5)
    if num == 1:
        return False

    for n in range(2, m+2):
        if num % n == 0:
            return False

    return True


input_func = sys.stdin.readline
if __name__ == '__main__':
    a, b = map(int, input_func().split())

    palindrome_list = []
    for num in range(1, 10001):
        make_palindrome(num)

    for number in sorted(palindrome_list):
        if number < a:
            continue
        elif b < number:
            print(-1)
            break

        if is_prime_number(number):
            print(number)
