import sys


def next_permutations(_string):
    start = len(_string)-2
    while start >= 0 and _string[start] >= _string[start+1]:
        start -= 1
    if start == -1:
        return None

    end = len(_string)-1
    while _string[start] >= _string[end]:
        end -= 1

    _string[start], _string[end] = _string[end], _string[start]
    next_p = _string[:start+1] + _string[start+1:][::-1]
    return next_p


input_func = sys.stdin.readline
if __name__ == '__main__':
    T = int(*map(int, input_func().split()))

    for _ in range(T):
        input_string = list(*map(str, input_func().split()))
        answer = next_permutations(input_string)
        print(''.join(answer) if answer else ''.join(input_string))
