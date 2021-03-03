#Summer/Winter Coding(~2018)
def solution(dirs):
    maps = [[0]*11 for _ in range(11)]
    maps[5][5] = 1
    visited = []
    count = 0
    
    x, y, nx, ny = 5, 5, 5, 5
    for d in dirs:
        if d == 'U':
            nx = x-1
        elif d == 'D':
            nx = x+1
        elif d == 'L':
            ny = y-1
        elif d == 'R':
            ny = y+1
        
        if 0<=nx<11 and 0<=ny<11:
            if maps[nx][ny] == 0:
                maps[nx][ny] = 1
                visited.append([x, y, nx, ny])
                visited.append([nx, ny, x, y])
                count += 1
            else:
                if [x, y, nx, ny] not in visited:
                    visited.append([x, y, nx, ny])
                    visited.append([nx, ny, x, y])
                    count += 1
        else:
            if nx < 0: nx = 0
            elif nx >= 11: nx = 10
            if ny < 0: ny = 0
            elif ny >= 11: ny = 10
        
        x, y = nx, ny

    return count
