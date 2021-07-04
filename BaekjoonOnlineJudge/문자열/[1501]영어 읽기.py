import sys
from collections import defaultdict


input_func = sys.stdin.readline
if __name__ == '__main__':
    N = int(*map(int, input_func().split()))
    word_dictionary = defaultdict(lambda: defaultdict(int))
    for _ in range(N):
        dict_word = str(*map(str, input_func().split()))
        if len(dict_word) < 2:
            first_key = dict_word
            second_key = ''
        else:
            first_key = dict_word[0]+dict_word[-1]
            second_key = ''.join(sorted(dict_word[1:-1]))

        word_dictionary[first_key][second_key] += 1

    M = int(*map(int, input_func().split()))
    for _ in range(M):
        sentences = list(map(str, input_func().split()))
        count = 1
        for word in sentences:
            if len(word) < 2:
                first_key = word
                second_key = ''
            else:
                first_key = word[0]+word[-1]
                second_key = ''.join(sorted(word[1:-1]))

            count *= word_dictionary[first_key][second_key]

        print(count)
