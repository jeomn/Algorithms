#2018 KAKAO BLIND RECRUITMENT
#20210427

def check_board(x, y, board):
    filter = [(x, y+1), (x+1, y), (x+1, y+1)]
    value = board[x][y]
    for _x, _y in filter:
        if value != board[_x][_y]:
            return False
    return True

def solution(m, n, board):
    answer = 0
    
    while True:
        erase_board = []
        for r in range(m-1):
            for c in range(n-1):
                if board[r][c] == '0':
                    continue
                
                if check_board(r, c, board):
                    erase_board.extend(
                        [(r, c), (r+1, c), (r, c+1), (r+1, c+1)])
        
        erase_board = set(erase_board)
        if not erase_board:
            break
        
        erase_board = list(erase_board)
        for x, y in sorted(erase_board, key=lambda x: (x[0], x[1])):
            if x == 0:
                board[x] = board[x][:y]+'0'+board[x][y+1:]
            else:
                for r in range(x, -1, -1):
                    if r == 0:
                        board[0] = board[0][:y]+'0'+board[0][y+1:]
                    else:
                        board[r] = board[r][:y]+board[r-1][y]+board[r][y+1:]
                    
            answer += 1
            
    return answer
