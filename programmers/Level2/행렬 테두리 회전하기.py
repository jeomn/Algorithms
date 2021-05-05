#20210506
#2021 Dev-Matching: 웹 백엔드 개발자(상반기)

def solution(rows, columns, queries):
    answer = []
    
    map = [[(r*columns)+c for c in range(1, columns+1)] for r in range(rows)]
    
    for q in queries:
        start = (q[0]-1, q[1]-1)
        end = (q[2]-1, q[3]-1)
        
        rotate_coor = [(start[0], y) for y in range(start[1], end[1]+1)]
        rotate_coor.extend([(x, end[1]) for x in range(start[0]+1, end[0])])
        rotate_coor.extend([(end[0], y) for y in range(start[1], end[1]+1)][::-1])
        rotate_coor.extend([(x, start[1]) for x in range(start[0]+1, end[0])][::-1])

        rotate_list = []
        for rc in rotate_coor:
            rotate_list.append(map[rc[0]][rc[1]])
        
        rotate_list = [rotate_list[-1]] + rotate_list[:-1]
        
        answer.append(min(rotate_list))
        
        for idx in range(len(rotate_coor)):
            map[rotate_coor[idx][0]][rotate_coor[idx][1]] = rotate_list[idx]
    
    return answer
