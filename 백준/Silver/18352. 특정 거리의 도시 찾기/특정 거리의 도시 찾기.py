from collections import deque
import sys
N, M, K, X = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)


dist = [-1] * (N + 1)
visited = [0] * (N+1)
dist[X] = 0
visited[X] = 1
queue = deque([X])

while queue:
    now = queue.popleft()
    for nxt in graph[now]:
        if dist[nxt] == -1 and not visited[nxt]:
            visited[nxt] = 1
            dist[nxt] = dist[now] + 1
            queue.append(nxt)

# 거리 K인 노드 찾기
res = [i for i in range(1, N + 1) if dist[i] == K]

if res:
    for city in sorted(res):
        print(city)
else:
    print(-1)
