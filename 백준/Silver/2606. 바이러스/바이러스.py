import sys

N = int(sys.stdin.readline().rstrip())
M = int(sys.stdin.readline().rstrip())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int,sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)


visitied = [0] * (N+1)

def dfs(n):
    visitied[n] = 1

    for nxt in graph[n]:
        if not visitied[nxt]:
            dfs(nxt)

dfs(1)
print(sum(visitied)-1)


