import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

N, M = map(int,input().split())

graph = [[] for _ in range(N+1)]

for i in range(M):
    u, v = map(int,input().split())
    graph[u].append(v)
    graph[v].append(u)

count = 0
visited = [0] * (N+1)
def dfs(v):
    visited[v] = 1
    for n in graph[v]:
        if not visited[n]:
            dfs(n)

for i in range(1, N+1):
    if not visited[i]:
        dfs(i)
        count += 1

print(count)


