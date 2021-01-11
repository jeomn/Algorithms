#힙(Heap)
import heapq

def solution(scoville, K):
    answer = 0
    h_scoville = []
    for i in range(len(scoville)):
        heapq.heappush(h_scoville, scoville[i])
    
    while h_scoville[0] < K+1:
        s1 = heapq.heappop(h_scoville)
        s2 = heapq.heappop(h_scoville)
        heapq.heappush(h_scoville, (s1+(s2*2)))
        answer += 1
        if len(h_scoville) == 1 and h_scoville[0] < K:
            answer = -1
            break

    return answer
