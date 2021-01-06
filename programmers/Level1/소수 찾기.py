def solution(n):
    eratos = ['True'] * n
    eratos[0] = 'False'
    Max = int(n ** 1/2)
    for i in range(2, Max+1):
        if eratos[i-1] == 'True':
            for j in range(i, n+1, i):
                eratos[j-1] = 'False'
            eratos[i-1] = 'True'
            
    return eratos.count('True')
