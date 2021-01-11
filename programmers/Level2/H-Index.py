#
def solution(citations):
    answer = 0
    h = []
    citations.sort(reverse=True)
    
    for i, j in enumerate(citations, start=1):
        h.append(min(i, j))
    
    answer = max(h)
    return answer
