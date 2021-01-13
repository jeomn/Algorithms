import collections

def solution(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    
    return ''.join(answer)


#20210108_review
from collections import Counter

def solution(participant, completion):
    n_com = Counter(participant) - Counter(completion)
    answer = list(n_com)[0]
    return answer

