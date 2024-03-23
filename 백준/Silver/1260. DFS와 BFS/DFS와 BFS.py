import sys
from collections import deque

N, M, V = map(int,sys.stdin.readline().split())

graph = [[] for _ in range(N+1)]

visited = [0] * (N+1)
visited1 = [0] * (N+1)

def dfs(graph, v, visited):
    visited[v] = 1
    print(v,end=' ')
    for i in graph[v]:
        if not visited[i]:
            dfs(graph,i,visited)

def bfs(graph, v, visited1):
    queue = deque([v])
    visited1[v] = 1
    while queue:
        val = queue.popleft()
        print(val,end=' ')
        for i in graph[val]:
            if not visited1[i]:
                queue.append(i)
                visited1[i] = 1

for _ in range(M):
    a,b = map(int,sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph:
    i.sort()

dfs(graph, V, visited)
print()
bfs(graph, V, visited1)