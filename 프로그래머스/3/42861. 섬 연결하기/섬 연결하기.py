import heapq
def solution(n, costs):
    answer = 0
    graph = [[] for _ in range(n)]
    for a,b,cost in costs:
        graph[a].append((cost, b))
        graph[b].append((cost, a))
        
    visited = [0] * n
    
    hq = [(0,0)]
    total = 0
    while hq:
        cost, node = heapq.heappop(hq)
        if visited[node]:
            continue
        total += cost
        visited[node] = 1
        for next_cost, next_node in graph[node]:
            if not visited[next_node]:
                heapq.heappush(hq,(next_cost,next_node))
          
    return total