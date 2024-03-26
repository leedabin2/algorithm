import sys
from collections import deque

N, M, K, X = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(N+1)]
distance = [-1] * (N+1)
distance[X] = 0

for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)

q = deque([X])

while q:
    node = q.popleft()

    for nxt in graph[node]:
        if distance[nxt] == -1:
            distance[nxt] = distance[node] + 1
            q.append(nxt)

if K not in distance:
    print(-1)
else:
    for i in range(len(distance)):
        if distance[i] == K:
            print(i)


