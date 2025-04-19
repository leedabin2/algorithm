import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
M = int(input())

graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [0] * (N + 1)
queue = deque()
queue.append((1, 0))  
visited[1] = True
count = 0

while queue:
    node, depth = queue.popleft()
    if depth >= 2:
        continue
    for n in graph[node]:
        if not visited[n]:
            visited[n] = 1
            queue.append((n, depth + 1))
            count += 1  

print(count)
