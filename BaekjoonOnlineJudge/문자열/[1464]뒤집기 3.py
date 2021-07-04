import sys


input_func = sys.stdin.readline
if __name__ == '__main__':
    S = list(*map(str, input_func().split()))

    temp_S = S[0]
    for idx in range(len(S)-1):
        if temp_S[idx] < S[idx+1]:
            temp_S = S[idx+1] + temp_S
        else:
            temp_S += S[idx+1]

    print(''.join(reversed(temp_S)))
