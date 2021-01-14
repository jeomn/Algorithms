#월간 코드 챌린지 시즌1
from collections import Counter
def solution(s):
    count = 0
    czero = Counter(s)['0']
    dzero = 0

    while s != '1':
        #변환 횟수 카운트
        count += 1
        #일단 기존 0 갯수 더해둠
        dzero += czero
        #s에서 0 제거
        s  = '1'*(Counter(s)['1'])
        #s의 길이 체크
        cs = len(s)
        #s의 길이를 이진 변환하여 s에 덮어씌움
        s = bin(cs)[2:]
        #s의 '0'갯수를 세어 czero 값으로
        czero = Counter(s)['0']
    
    answer = [count, dzero]
    return answer
