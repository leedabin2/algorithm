import sys
sys.setrecursionlimit(10**6)
N, M, R = map(int,sys.stdin.readline().split())

graph = [ [] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int,sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)


visited = [0] * (N+1)
ans = [0] * (N+1)
cnt = 1
def dfs(r):
    global cnt

    visited[r] = 1
    ans[r] = cnt

    graph[r].sort(reverse=True)
    for i in graph[r]:
        if not visited[i]:
            cnt += 1
            visited[i] = 1
            dfs(i)

dfs(R)

for i in ans[1:]:
    print(i)

