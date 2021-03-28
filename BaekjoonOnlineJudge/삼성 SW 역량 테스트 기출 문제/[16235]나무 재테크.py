import sys
from collections import deque


def year(tree):
    global answer
    for r in range(N):
        for c in range(N):
            tree[r][c].sort()
            #봄
            for idx in range(len(tree[r][c])):
                t = tree[r][c][idx]
                if t <= field[r][c]:
                    tree[r][c][idx] += 1
                    field[r][c] -= t
                else:
                    died_tree = tree[r][c][idx:]
                    for dt in died_tree:
                        field[r][c] += dt//2
                        answer -= 1
                    tree[r][c] = tree[r][c][:idx]
                    break

            #양분 더하기
            #겨울
            field[r][c] += food[r][c]

    #가을(나무 번식)
    for r in range(N):
        for c in range(N):
            t_count = 0
            if tree[r][c]:
                for t in tree[r][c]:
                    if t % 5 == 0:
                        t_count += 1

            if t_count > 0:
                for idx in range(8):
                    nr = r + dx[idx]
                    nc = c + dy[idx]
                    if 0<=nr<N and 0<=nc<N:
                        tree[nr][nc].extend([1]*t_count)
                        answer += t_count

    return tree


if __name__=="__main__":
    N, M, K = map(int, sys.stdin.readline().split())
    food = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
    tree = [[[] for _ in range(N)] for _ in range(N)]
    answer = 0
    for _ in range(M):
        x, y, z = map(int, sys.stdin.readline().split())
        tree[x-1][y-1].append(z)
        answer += 1

    field = [[5]*N for _ in range(N)]
    dx = [-1, -1, -1, 0, 0, 1, 1, 1]
    dy = [-1, 0, 1, -1, 1, -1, 0, 1]
    for _ in range(K):
        tree = year(tree)

    print(answer)


#===================================================================================
#시간초과 코드
import sys
from collections import defaultdict
from collections import deque


def year(tree):
    global answer
    for r in range(N):
        for c in range(N):
            new_tree = deque()
            add_food = 0
            #봄
            while tree[r, c]:
                t = tree[r, c].pop()
                if t <= field[r][c]:
                    new_tree.appendleft(t+1)
                    field[r][c] -= t
                else:
                    add_food += t//2
                    answer -= 1
            tree[r, c] += new_tree

            #양분 더하기
            #겨울
            field[r][c] += food[r][c]
            #여름
            field[r][c] += add_food

    #가을(나무 번식)
    for (x, y), t_list in tree.items():
        t_count = 0
        if len(t_list) == 0:
            continue

        for t in t_list:
            #제일 앞 나무가 제일 큰 나무
            if t < 5:
                break

            if t % 5 == 0:
                t_count += 1

        for idx in range(8):
            nx = x + dx[idx]
            ny = y + dy[idx]
            if 0<=nx<N and 0<=ny<N:
                breed_tree = deque([1]*t_count)
                tree[nx, ny] += breed_tree
                answer += t_count

    return tree


if __name__=="__main__":
    N, M, K = map(int, sys.stdin.readline().split())
    food = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
    tree = defaultdict(deque)
    answer = 0
    for _ in range(M):
        x, y, z = map(int, sys.stdin.readline().split())
        tree[x-1, y-1].append(z)
        answer += 1

    field = [[5]*N for _ in range(N)]
    dx = [-1, -1, -1, 0, 0, 1, 1, 1]
    dy = [-1, 0, 1, -1, 1, -1, 0, 1]
    for _ in range(K):
        tree = year(tree)

    print(answer)
