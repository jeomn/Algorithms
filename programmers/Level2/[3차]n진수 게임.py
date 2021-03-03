#2018 KAKAO BLIND RECRUITMENT
def base_system(num, base):
    notation = '0123456789ABCDEF'
    base_notation = ''
    if num == 0:
        base_notation += '0'
    while num > 0:
        num, mod = divmod(num, base)
        base_notation += notation[mod]
        
    return base_notation[::-1]
        

def solution(n, t, m, p):
    tube = ''
    num = 0
    turns = 0
    while len(tube) != t:
        notation = base_system(num, n)
        for idx in range(len(notation)):
            if len(tube) == t:
                break

            if turns%m == (p-1):
                tube += notation[idx]
            turns += 1

        num += 1

    return tube
