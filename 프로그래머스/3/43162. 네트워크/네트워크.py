from collections import deque

def solution(n, computers):
    answer = 0
    visited = [0] * n
    for i in range(n):
        if not visited[i]:
            queue = deque([i])
            visited[i] = 1
            while queue:
                next_node = queue.popleft()
                for j in range(n):
                    if not visited[j] and computers[next_node][j] == 1:
                        visited[j] = 1
                        queue.append(j)
            answer += 1
            
            
    return answer