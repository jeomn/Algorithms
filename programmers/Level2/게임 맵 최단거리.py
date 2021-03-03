#찾아라 프로그래밍 마에스터
from collections import deque

def solution(maps):
    start = [0, 0]
    n, m = len(maps[0]), len(maps)
    visited = [[0]*n for _ in range(m)]
    visited[0][0] = 1
    route = deque([start])
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    while route:
        x, y = route.popleft()
        for i in range(4):
            nx, ny = dx[i] + x, dy[i] + y
            
            if 0 <= nx < m and 0 <= ny <n:
                if visited[nx][ny] == 0 and maps[nx][ny] == 1:
                    visited[nx][ny] = visited[x][y] + 1
                    route.append([nx, ny])
    
    answer = visited[m-1][-1]
    if answer == 0:
        return -1
    else:
        return answer
