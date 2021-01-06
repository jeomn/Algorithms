def solution(s):
    answer = ''.join(reversed(sorted(s)))
    return answer

#20210106_review
def solution(s):
    return ''.join(sorted(list(s), reverse=True))
