import sys
from collections import deque

N, M, V = map(int,sys.stdin.readline().split())

graph = [[] for _ in range(N+1)]

visited_dfs = [0] * (N+1)
visited_bfs = [0] * (N+1)

for _ in range(M):
    a,b = map(int,sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

for i in graph:
    i.sort()

def dfs(node):
    visited_dfs[node] = 1
    print(node,end=' ')
    for nxt in graph[node]:
        if not visited_dfs[nxt]:
            dfs(nxt)

def bfs(V):
    q = deque([V])

    while q:
        node = q.popleft()
        visited_bfs[V] = 1
        print(node,end=' ')

        for nxt in graph[node]:
            if not visited_bfs[nxt]:
                q.append(nxt)
                visited_bfs[nxt] = 1

dfs(V)
print()
bfs(V)
