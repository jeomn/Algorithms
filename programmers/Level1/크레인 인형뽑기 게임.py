#2019 카카오 개발자 겨울 인턴십
def solution(board, moves):
    answer = 0
    collect = []
    
    for i in range(len(moves)):
        x = moves[i]-1

        for j in range(len(board)):
            if board[j][x] == 0:
                continue
            else:
                collect.append(board[j][x])
                board[j][x] = 0
                break

        if len(collect) >= 2:
            if collect[-1] == collect[-2]:
                collect.pop()
                collect.pop()
                answer += 2                

    return answer
