#2018 KAKAO BLIND RECRUITMENT
#2진수
def nbase2(n, a):
    abase = []
    while a > 0:
        abase.append(str(a%2))
        a //= 2
    if len(abase) < n:
        abase.append('0' * (n-len(abase)))
    return ''.join(reversed(abase))

#본 코드
def solution(n, arr1, arr2):
    answer = []
    arr1base2 = []
    arr2base2 = []

    for i in range(len(arr1)):
        arr1base2.append(nbase2(n, arr1[i]))
        arr2base2.append(nbase2(n, arr2[i]))
    

    #합치기
    for i in range(n):
        a = ''
        for j in range(n):
            if (arr1base2[i][j] == '1') or (arr2base2[i][j] == '1'):
                a += '#'
            else:
                a += ' '
        print(a)
        answer.append(a)
    
    return answer
