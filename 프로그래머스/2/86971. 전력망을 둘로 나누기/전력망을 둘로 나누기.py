from collections import deque
def bfs(start,graph,n,visited):
    count = 1
    queue = deque([start])
    visited[start] = 1
    
    while queue:
        nxt_node = queue.popleft()
        for n in graph[nxt_node]:
            if not visited[n]:
                visited[n] = 1
                queue.append(n)
                count += 1
    return count
        
def solution(n, wires):
    min_diff = n
    for i in range(len(wires)):
        graph = [[] for _ in range(n+1)]
        for j in range(len(wires)):
            if i == j:
                continue
            a, b = wires[j]
            
            graph[a].append(b)
            graph[b].append(a)     
    
        visited = [0] * (n+1)
        graph_count = bfs(1,graph,n,visited)
        diff = abs((n - graph_count) - graph_count)
    
        min_diff = min(diff,min_diff)
    
    return min_diff