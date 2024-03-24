import sys,queue
from collections import deque

N, M =map(int,sys.stdin.readline().split())

graph = [[]*(N+1) for _ in range(N+1)]

for _ in range(M):
    a,b = map(int,sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [0] * (N+1)

def bfs(s):
    q = deque([s])
    while q:
        node = q.popleft()
        visited[node] = 1

        for nxt in graph[node]:
            if not visited[nxt]:
                q.append(nxt)
                visited[nxt] = 1

# bfs(1)

cnt = 0
for i in range(1,N+1):
    if visited[i] == 0:
        bfs(i)
        cnt += 1

print(cnt)
