#20210504
#동적계획법(Dynamic Programming)

def solution(triangle):
    
    for r in range(1, len(triangle)):
        for c in range(len(triangle[r])):
            if c == 0:
                triangle[r][c] += triangle[r-1][0]
            elif c == len(triangle[r])-1:
                triangle[r][c] += triangle[r-1][-1]
            else:
                triangle[r][c] += max(triangle[r-1][c-1], triangle[r-1][c])
        
    answer = max(triangle[-1])
    return answer
