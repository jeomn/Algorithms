import sys
from collections import deque


def move_ball(x, y, d):
    nx, ny = x+dx[d], y+dy[d]
    move_distance = 0
    while board[nx][ny] == '.':
        nx += dx[d]
        ny += dy[d]
        move_distance += 1
    if board[nx][ny] == 'O':
        return nx, ny, move_distance
    else:
        return nx-dx[d], ny-dy[d], move_distance


def find_ball_move_direction(rx, ry, bx, by):
    route = deque([(rx, ry, bx, by, 1)])
    visited[rx][ry][bx][by] = True

    while route:
        rx, ry, bx, by, move_count = route.popleft()

        if move_count > 10:
            break

        for idx in range(4):
            nrx, nry, r_distance = move_ball(rx, ry, idx)
            nbx, nby, b_distance = move_ball(bx, by, idx)

            if board[nbx][nby] == 'O':
                continue
            elif board[nrx][nry] == 'O':
                return move_count
            else:
                if (nrx, nry) == (nbx, nby):
                    if r_distance > b_distance:
                        nrx -= dx[idx]
                        nry -= dy[idx]
                    else:
                        nbx -= dx[idx]
                        nby -= dy[idx]

                if not visited[nrx][nry][nbx][nby]:
                    visited[nrx][nry][nbx][nby] = True
                    route.append((nrx, nry, nbx, nby, move_count + 1))

    return -1


if __name__ == '__main__':
    N, M = map(int, sys.stdin.readline().split())
    board = []
    for r in range(N):
        board_line = str(*map(str, sys.stdin.readline().split()))
        for c in range(M):
            if board_line[c] == 'R':
                r_r, r_c = r, c
                board_line = board_line.replace('R', '.')
            elif board_line[c] == 'B':
                b_r, b_c = r, c
                board_line = board_line.replace('B', '.')
        board.append(board_line)

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    visited = [[[[False]*M for _ in range(N)] for _ in range(M)] for _ in range(N)]
    result = find_ball_move_direction(r_r, r_c, b_r, b_c)
    print(result)

    
    #20210916 REVIEW
    import sys
from collections import deque


def move_ball(x, y, dirc):
    move_cnt = 1
    nx, ny = x+dx[dirc], y+dy[dirc]
    while board[nx][ny] == '.':
        nx+=dx[dirc]
        ny+=dy[dirc]
        move_cnt+=1
    if board[nx][ny] == 'O': return nx, ny, move_cnt
    return nx-dx[dirc], ny-dy[dirc], move_cnt


def find_ball_direction(rx, ry, bx, by):
    route = deque([(rx, ry, bx, by, 1)])
    visited[rx][ry][bx][by] = True

    while route:
        rx, ry, bx, by, cnt = route.popleft()

        if cnt > 10: return -1

        for idx in range(4):
            nrx, nry, rmove = move_ball(rx, ry, idx)
            nbx, nby, bmove = move_ball(bx, by, idx)

            if board[nbx][nby] == 'O':
                continue
            elif board[nrx][nry] == 'O':
                return cnt
            else:
                if nrx == nbx and nry == nby:
                    if rmove < bmove:
                        nbx-=dx[idx]
                        nby-=dy[idx]
                    else:
                        nrx-=dx[idx]
                        nry-=dy[idx]

                if visited[nrx][nry][nbx][nby]: continue
                visited[nrx][nry][nbx][nby] = True
                route.append((nrx, nry, nbx, nby, cnt+1))
    return -1


input_func = sys.stdin.readline
if __name__ == '__main__':
    N, M = map(int, input_func().split())
    board = []
    red_x, red_y, blue_x, blue_y = -1, -1, -1, -1
    for r in range(N):
        temp = list(*map(str, input_func().split()))
        for c in range(M):
            if temp[c] == 'R':
                red_x, red_y = r, c
                temp[c] = "."
            if temp[c] == 'B':
                blue_x, blue_y = r, c
                temp[c] = "."
        board.append(temp)

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    visited = [[[[False]*M for _ in range(N)] for _ in range(M)] for _ in range(N)]
    result = find_ball_direction(red_x, red_y, blue_x, blue_y)
    print(result)
