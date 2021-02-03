#2019 KAKAO BLIND RECRUITMENT
from itertools import combinations
from itertools import chain

def solution(relation):
    answer = 0
    relationLength = len(relation)
    colLength = len(relation[0])
    subsetList= []
    uniqueList, minimalList = [], []
    
    for i in range(1, colLength + 1):
        subsetList.extend([list(k) for k in combinations([j for j in range(colLength)], i)]) 
    
    #유일성 검증
    for subset in subsetList:
        unique = True
        duplicateCheck = set()
        for row in range(len(relation)):
            data = ''
            for idx in subset:
                data += relation[row][idx]
            if data in duplicateCheck:
                unique = False
                break
            duplicateCheck.add(data)
        if unique:
            uniqueList.append(subset)
    
    uniqueList = sorted(uniqueList, key=lambda x: len(x))
    minimalList.append(set(uniqueList[0]))
    
    #최소성 검증
    for unique in uniqueList:
        unique = set(unique)
        minimal = True
        for mini in minimalList:
            if mini.issubset(unique):
                minimal = False
                break
        if minimal:
            minimalList.append(unique)

    answer = len(minimalList)
    return answer
