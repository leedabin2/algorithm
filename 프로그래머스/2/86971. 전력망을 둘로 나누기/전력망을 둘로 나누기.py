from collections import deque
def bfs(start,graph,visited):
    count = 1
    queue = deque([start])
    visited[start] = 1
    
    while queue:
        node = queue.popleft()
        for next_node in graph[node]:
            if not visited[next_node]:
                visited[next_node] = 1
                queue.append(next_node)
                count += 1
    
    return count
def solution(n, wires):
    answer = n
    for i in range(len(wires)):
        graph = [[] for _ in range(n+1)]
        for j in range(len(wires)):
            if i == j:
                continue
            a, b = wires[j]
            graph[a].append(b)
            graph[b].append(a)
        visited = [0] * (n+1)
        group_count = bfs(1,graph,visited)
        diff = abs((n - (group_count)) - group_count)
        answer = min(answer,diff)

    return answer