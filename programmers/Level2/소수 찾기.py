#완전탐색
from itertools import permutations

def prime_list(n):
    sieve = [True] * n
    m = int(n ** 0.5)
    for i in range(2, m + 1):
        if sieve[i] == True:           
            for j in range(i+i, n, i): 
                sieve[j] = False

    return [i for i in range(2, n) if sieve[i] == True]


def solution(numbers):
    answer = 0
    number_list = []
    for i in range(1, len(numbers)+1):
        permu_num = list(map(''.join, permutations(numbers, i)))
        for j in permu_num:
            number_list.append(int(j))
        number_list = list(set(number_list))
    
    eratos_list = prime_list(max(number_list)+1)

    for i in number_list:
        if i in eratos_list:
            answer += 1

    return answer
