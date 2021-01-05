def solution(n, m):
    answer = ''
    for i in range(m):
        answer += ('*'*n + '\n')

    return answer

a, b = map(int, input().strip().split(' '))
print(solution(a, b))
