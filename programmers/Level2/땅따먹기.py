def solution(land):
    answer = 0
    
    for i in range(0, len(land)-1):
        land[i+1][0] += max(land[i][1], land[i][2], land[i][3])
        land[i+1][1] += max(land[i][2], land[i][3], land[i][0])
        land[i+1][2] += max(land[i][3], land[i][0], land[i][1])
        land[i+1][3] += max(land[i][0], land[i][1], land[i][2])
    
    answer = max(land[-1])
    return answer
