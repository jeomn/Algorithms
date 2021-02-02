#2021 KAKAO BLIND RECRUITMENT

#from https://velog.io/@study-dev347/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%88%9C%EC%9C%84-%EA%B2%80%EC%83%89
import bisect

changes = []
tmp = []

# 16가지의 경우의 수를 만들어주는 함수
def make_cases():
    global changes, tmp
    if len(tmp) == 4:
        t = []
        for index in tmp: t.append(index)
        changes.append(t)
        return
    
    for i in (False, True):
        tmp.append(i)
        make_cases()
        tmp.pop()

# True를 가리키는 인덱스에 해당하는 속성 값을 '-'으로 바꿔준다.
def replace(change, data):
    for i in range(4):
        if change[i]: data[i] = '-'

    return data

def copy(data):
    _data = []
    for item in data: _data.append(item)

    return _data

def search(scores, num):
    size = len(scores)
    return size - bisect.bisect_left(scores, num, lo=0, hi=size)

def solution(info, query):
    global changes
    answer = []
    info_dict = {}
    make_cases()

    # query를 위한 info 전처리
    for data in info:
        data = data.split()
        score = int(data[-1])
        data = data[:4]
        
        for change in changes:
            _data = copy(data)
            _data = replace(change, _data)
            _data = ''.join(_data)

            if _data not in info_dict.keys(): info_dict[_data] = [score]
            else: info_dict[_data].append(score)

    # info_dict[key] 정렬
    for key in info_dict.keys(): info_dict[key].sort()

    for q in query:
        q = q.split()
        score = int(q[-1])
        _q = ''
        
        # query 문자열 처리
        for item in q[:len(q)-1]:
            if item != 'and': _q += item
                
        # 문의 조건을 만족하는 지원서들의 수 찾기
        if _q not in info_dict.keys(): answer.append(0)
        else:
            cnt = search(info_dict[_q], score)
            answer.append(cnt)

    return answer










"""
정확도 100, 효율성 0 => 시간초과

from itertools import combinations

def newGroup(info):
    _info = [[i, info[i]] for i in range(len(info))]
    infoGroup, infoGroup_temp = [['-', '-', '-', '-'] for i in range(0, 16)], []
    searchGroup = {}
    for i in range(0, len(_info)):
        infoGroup_temp.extend([list(k) for k in combinations([j for j in _info[:4]], i)])
        score = info[4]
    
    for i in range(len(infoGroup_temp)):
        for j in range(len(infoGroup_temp[i])):
            idx = infoGroup_temp[i][j][0]
            infoGroup[i][idx] = infoGroup_temp[i][j][1]
        infoGroup[i] = ''.join(infoGroup[i])   
        searchGroup[infoGroup[i]] = int(score)

    return searchGroup


def solution(info, query):
    answer = []
    #쿼리 데이터 처리
    queryList = [q.replace(" and", "").split(" ") for q in query]
    infoList = [i.split(" ") for i in info]
    searchGroup = [{}]
    
    for info in range(len(infoList)):
        searchGroup.append(newGroup(infoList[info]))
    
    for query in queryList:
        count = 0
        q = ''.join(query[:4])
        q_score = int(query[4])
        for search in searchGroup:
            if q in search.keys():
                if search[q] >= q_score:
                    count += 1
            
        answer.append(count)
    return answer
"""
    
    

"""
    #시간초과 코드

def solution(info, query):
    for query in queryList:
        info = infoList.copy()
        for q in range(len(query)):
            if query[q] == '-':
                continue
            
            for i in info:
                if i =='' or query[q] in i:
                    continue                
                else:
                    if query[q].isdigit():
                        if int(query[q]) > int(i[4]):
                            info[info.index(i)] = ''
                    else:
                        info[info.index(i)] = ''

            while '' in info:
                info.remove('')

        answer.append(len(info))

    return answer
"""
