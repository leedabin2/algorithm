import sys
from collections import deque

N, M = map(int,sys.stdin.readline().split())
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int,sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

dist = [-1] * (N+1)
dist[1] = 0
queue = deque([1])

while queue:
    node = queue.popleft()
    for nxt in graph[node]:
        if dist[nxt] == -1:
            dist[nxt] = dist[node] + 1
            queue.append(nxt)

max_dist = max(dist)
final_num = [i for i, d in enumerate(dist) if d == max_dist ]
print(f'{final_num[0]} {max_dist} {len(final_num)}')

