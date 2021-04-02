#그래프
#20210402
import queue
from collections import defaultdict

def Dijsktra(start, graph, route):
    
    _q = queue.PriorityQueue()
    _q.put((start, 0))
    route[start] = 0
    
    while not _q.empty():
        node, dist = _q.get()
        
        if route[node] < dist:
            continue
        
        for neighbor in graph[node].keys():
            new_dist = dist + graph[node][neighbor]
            if route[neighbor] > new_dist:
                route[neighbor] = new_dist
                _q.put((neighbor, new_dist))
    return route

                
def solution(n, edge):
    answer = 0
    
    adj_node = defaultdict(dict)
    for start_node, end_node in edge:
        adj_node[start_node][end_node] = 1
        adj_node[end_node][start_node] = 1
    
    route = {key: 1e9 for key in range(1, n+1)}
    
    new_route = Dijsktra(1, adj_node, route)
    
    max_dist = max(new_route.values())
    for key, value in new_route.items():
        if value < max_dist:
            continue
        answer += 1
    
    return answer
