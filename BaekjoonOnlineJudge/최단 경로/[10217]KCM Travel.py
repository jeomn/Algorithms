#Python3, Pypy3 모두 시간초과
"""
import sys
import queue


def dijkstra(start, max, route, graph):
    _q = queue.PriorityQueue()
    #시간, 가격, 노드
    _q.put((0, 0, start))
    route[start][0] = 0
    while not _q.empty():
        time, price, node = _q.get()

        if route[node-1][price] < time or node not in graph.keys():
            continue

        for neighbor in graph[node].keys():
            for way in graph[node][neighbor]:
                new_time = time + way[1]
                new_price = price + way[0]

                if new_price > max or route[neighbor-1][new_price] < new_time:
                    continue

                for p in range(new_price, max+1):
                    if route[node-1][p] > new_time:
                        route[node-1][p] = new_time

                route[neighbor-1][new_price] = new_time
                _q.put((new_time, new_price, neighbor))

    return route


if __name__=="__main__":
    T = int(*map(int, sys.stdin.readline().split()))

    for _ in range(T):
        N, M, K = map(int, sys.stdin.readline().split())

        #{1: {2: [[1, 1]], 3: [[3, 30]]}, 2: {3: [[1, 1]]}}
        airports = {}
        for _ in range(K):
            u, v, c, d = map(int, sys.stdin.readline().split())
            if u not in airports.keys():
                airports[u] = {v: [[c, d]]}
            else:
                if v not in airports[u].keys():
                    airports[u][v] = [[c, d]]
                else:
                    airports[u][v].append([c, d])

        route = [[1e9]*(M+1) for node in range(N)]
        minRoute = dijkstra(1, M, route, airports)

        answer = min(minRoute[N-1])
        if answer == 1e9:
            print('Poor KCM')
        else:
            print(answer)
"""


#DP 풀이
#Pypy3

import sys


if __name__=="__main__":
    T = int(*map(int, sys.stdin.readline().split()))

    for _ in range(T):
        N, M, K = map(int, sys.stdin.readline().split())

        #{1: {2: [[1, 1]], 3: [[3, 30]]}, 2: {3: [[1, 1]]}}
        airports = {}
        for _ in range(K):
            u, v, c, d = map(int, sys.stdin.readline().split())
            if u not in airports.keys():
                airports[u] = {v: [[c, d]]}
            else:
                if v not in airports[u].keys():
                    airports[u][v] = [[c, d]]
                else:
                    airports[u][v].append([c, d])

        route = [[1e9]*(M+1) for node in range(N)]
        #route[노드][비용] = 시간
        route[0][0] = 0
        for price in range(M+1):
            for node in range(N):
                #경로가 이어지지 않은 경우
                if route[node][price] == 1e9 or node+1 not in airports.keys():
                    continue

                for neighbor in airports[node+1].keys():
                    for p, t in airports[node+1][neighbor]:
                        #비용 초과
                        if price + p > M:
                            continue

                        route[neighbor-1][price+p] = min(route[neighbor-1][price+p], route[node][price]+t)

        answer = min(route[N-1])
        if answer == 1e9:
            print('Poor KCM')
        else:
            print(answer)

