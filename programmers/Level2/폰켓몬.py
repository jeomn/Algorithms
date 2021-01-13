#찾아라 프로그래밍 마에스터
from collections import Counter
def solution(nums):
    max_kind = int(len(nums)/2)
    cnums = Counter(nums)
    
    if len(cnums) <= max_kind:
        answer = len(cnums)
    else:
        answer = max_kind
        
    return answer
