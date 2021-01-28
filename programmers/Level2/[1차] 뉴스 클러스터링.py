#2018 KAKAO BLIND RECRUITMENT
def solution(str1, str2):
    answer, similar = 0, 65536
    str1Set, str2Set = [], []
    str1, str2 = str1.lower(), str2.lower()
    
    #str1, str2 다중집합 생성
    for i in range(len(str1)-1):
        if str1[i].isalpha() and str1[i+1].isalpha():
            str1Set.append(str1[i:i+2])
        else:
            continue
    for i in range(len(str2)-1):
        if str2[i].isalpha() and str2[i+1].isalpha():
            str2Set.append(str2[i:i+2])
        else:
            continue    
    
    #합집합
    if len(str1Set) > len(str2Set):
        str1Set, str2Set = str2Set, str1Set
    strUnion = str1Set.copy()
    str1tmp, str2tmp = str1Set.copy(), str2Set.copy()
    for i in range(len(str2Set)):
        if str1tmp and str2Set[i] in str1tmp:
            str1tmp.remove(str2Set[i])
            continue       
        else:
            strUnion.append(str2Set[i])
    
    #교집합
    strInter = []
    for i in str1Set:
        if i in str2tmp:
            str2tmp.remove(i)
            strInter.append(i)
    
    #자카드 유사도 계산
    if len(strUnion) != 0:
        similar *= (len(strInter)/len(strUnion))
    
    answer = int(similar)
    return answer
