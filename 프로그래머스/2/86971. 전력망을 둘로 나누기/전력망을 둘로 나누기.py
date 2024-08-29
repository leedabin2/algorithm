from collections import deque

def bfs(start,graph):
    
    visited = [0] * len(graph)
    visited[start] = 1
    queue = deque([start])
    cnt = 1
    
    while queue:
        node = queue.popleft()
        for next_node in graph[node]:
            if not visited[next_node]:
                visited[next_node] = 1
                queue.append(next_node)
                cnt += 1

    return cnt;
    

def solution(n, wires):
    answer = float('inf')
    
    for i in range(len(wires)):
        
        temp = wires[:i] + wires[i+1:]
      
        graph = [ [] for i in range(1,n+2)]
        for wire in temp:
            graph[wire[0]].append(wire[1])
            graph[wire[1]].append(wire[0])

        res = bfs(1,graph)
        diff = abs(res - (n - res)) 
        answer = min(answer, diff) 
        min_answer = min(answer,res)

            
    return min_answer