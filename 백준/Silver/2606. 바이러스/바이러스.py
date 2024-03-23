import sys

N = int(sys.stdin.readline().rstrip())

graph = [[] for _ in range(N+1)]

computer_cnt = int(sys.stdin.readline().rstrip())

visited = [0] * (N+1)

def dfs(graph, v, visited):
    visited[v] = 1

    for i in graph[v]:
        if not visited[i]:
            dfs(graph,i,visited)

for _ in range(computer_cnt):
    a,b = map(int,sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

dfs(graph, 1, visited)

cnt = 0
for i in visited:
    if i == 1:
        cnt += 1

print(cnt-1)





