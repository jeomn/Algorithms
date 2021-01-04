def solution(n):
    n = list(str(n))
    for i in range(0, len(n)):
        for j in range(0, len(n)-1):
            if n[i] > n[j]:
                n[i], n[j] = n[j], n[i]

    answer = int("".join(n))
    return answer
