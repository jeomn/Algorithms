import collections

def solution(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    
    return ''.join(answer)
