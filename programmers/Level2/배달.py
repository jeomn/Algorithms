#20210303 Summer/Winter Coding(~2018)
#다익스트라
import queue

def solution(N, road, K):
    
    graph = {}
    for a, b, c in road:
        if a not in graph.keys():
            graph[a] = {b: c}
        else:
            if b not in graph[a].keys():
                graph[a][b] = c
            else:
                graph[a][b] = min(graph[a][b], c)
        
        if b not in graph.keys():
            graph[b] = {a: c}
        else:
            if a not in graph[b].keys():
                graph[b][a] = c
            else:
                graph[b][a] = min(graph[b][a], c)   
    
    #다익스트라
    q = queue.PriorityQueue()
    q.put((0, 1)) #(시간, 마을)
    route = {node+1: 1e9 for node in range(N)}
    route[1] = 0
    while not q.empty():
        time, node = q.get()
        
        if route[node] < time or node not in graph.keys():
            continue
        
        for neighbor in graph[node].keys():
            new_time = time + graph[node][neighbor]
            if route[neighbor] > new_time:
                route[neighbor] = new_time
                q.put((new_time, neighbor))
        
    answer = 0
    for node in range(1, N+1):
        if route[node] <= K:
            answer += 1
    
    return answer
